package shop.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import shop.domain.*;
import shop.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class InventoryIncreased extends AbstractEvent {

    private Long id;

    public InventoryIncreased() {
        super();
    }
}
//>>> DDD / Domain Event
