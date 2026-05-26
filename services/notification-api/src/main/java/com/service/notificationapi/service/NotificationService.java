package com.service.notificationapi.service;

import com.service.notificationapi.entity.Notifications;
import com.service.notificationapi.entity.Processed_Events;
import com.service.notificationapi.repository.NotificationRepository;
import com.service.sharedevents.CustomerCreatedEvent;
import com.service.notificationapi.repository.ProcessedEventRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;


@Service
@RequiredArgsConstructor
public class NotificationService {

    private final ProcessedEventRepository processedRepository;
    private final NotificationRepository notificationRepository;

    @Transactional
    public void process(@org.jetbrains.annotations.UnknownNullability CustomerCreatedEvent event) {
        if (processedRepository.existsByEventId(event.getEventId().toString())) {
            System.out.println("evento duplicado ignorado.");
        }
        Notifications notification = new Notifications();


        notification.setMessage("user criado !" + event.getUsername());
        notification.setEventType("USER_CREATED");
        notification.setStatus("PROCESSED");
        notification.setCreatedAt(Instant.now());

        notificationRepository.save(notification);

        processedRepository.save(
                new Processed_Events(
                        Instant.now(),
                        event.getEventId().toString()
                )
        );
    }
}
