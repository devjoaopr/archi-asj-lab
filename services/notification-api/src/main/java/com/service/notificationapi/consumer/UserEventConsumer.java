package com.service.notificationapi.consumer;

import com.service.notificationapi.event.UserCreatedEvent;
import com.service.notificationapi.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserEventConsumer {
    private final NotificationService notificationService;

    @KafkaListener(
            topics = "user.created",
            groupId = "notification-group"
    )

    public void consume(UserCreatedEvent event){
        notificationService.process(event);
    }

}
