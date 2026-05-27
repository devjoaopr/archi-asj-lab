package com.service.customer.producer;

import com.service.sharedevents.CustomerCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomerProducer {

    private final KafkaTemplate<
            String,
            CustomerCreatedEvent
            > kafkaTemplate;

    public void publish(
            CustomerCreatedEvent event
    ){

        kafkaTemplate.send( 
                "customer.created",
                event
        );

    }

}
