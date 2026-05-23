package com.service.notificationapi.repository;

import com.service.notificationapi.entity.Processed_Events;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProcessedEventRepository extends JpaRepository<Processed_Events, UUID> {
    boolean existsByEventId(String eventId);
}
