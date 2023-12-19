package shop.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import shop.config.kafka.KafkaProcessor;
import shop.domain.*;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    DeliveryRepository deliveryRepository;

    @Autowired
    InventoryRepository inventoryRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Orderplaced'"
    )
    public void wheneverOrderplaced_StartDelivery(
        @Payload Orderplaced orderplaced
    ) {
        Orderplaced event = orderplaced;
        System.out.println(
            "\n\n##### listener StartDelivery : " + orderplaced + "\n\n"
        );

        // Sample Logic //
        Delivery.startDelivery(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='DeliveryStarted'"
    )
    public void wheneverDeliveryStarted_DecreaseInventory(
        @Payload DeliveryStarted deliveryStarted
    ) {
        DeliveryStarted event = deliveryStarted;
        System.out.println(
            "\n\n##### listener DecreaseInventory : " + deliveryStarted + "\n\n"
        );

        // Sample Logic //
        Inventory.decreaseInventory(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Ordercancelled'"
    )
    public void wheneverOrdercancelled_ReturnDelivery(
        @Payload Ordercancelled ordercancelled
    ) {
        Ordercancelled event = ordercancelled;
        System.out.println(
            "\n\n##### listener ReturnDelivery : " + ordercancelled + "\n\n"
        );

        // Sample Logic //
        Delivery.returnDelivery(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='DeliveryReturned'"
    )
    public void wheneverDeliveryReturned_IncreaseStock(
        @Payload DeliveryReturned deliveryReturned
    ) {
        DeliveryReturned event = deliveryReturned;
        System.out.println(
            "\n\n##### listener IncreaseStock : " + deliveryReturned + "\n\n"
        );

        // Sample Logic //
        Inventory.increaseStock(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
