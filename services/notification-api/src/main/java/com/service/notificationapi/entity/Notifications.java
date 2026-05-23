package com.service.notificationapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Notifications {
    @Column(name = "created_at")
    private Instant createdAt;
    @Column(name = "status")
    private String status;
    @Column(name = "message")
    private String message;
    @Column(name = "event_type")
    private String eventType;
    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

}
