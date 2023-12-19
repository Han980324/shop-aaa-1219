package shop.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import shop.domain.*;
import shop.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class Ordercancelled extends AbstractEvent {

    private Long id;

    public Ordercancelled(Order aggregate) {
        super(aggregate);
    }

    public Ordercancelled() {
        super();
    }
}
//>>> DDD / Domain Event
