package com.service.sharedevents;

import java.util.UUID;

public class CustomerCreatedEvent {

    private UUID eventId;      // id único do evento
    private UUID customerId;   // id do usuário

    private String username;
    private Integer age;
    private String cpf;

    public CustomerCreatedEvent() {
    }

    public CustomerCreatedEvent(
            UUID eventId,
            UUID customerId,
            String username,
            Integer age,
            String cpf
    ) {
        this.eventId = eventId;
        this.customerId = customerId;
        this.username = username;
        this.age = age;
        this.cpf = cpf;
    }

    public UUID getEventId() {
        return eventId;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public String getUsername() {
        return username;
    }

    public Integer getAge() {
        return age;
    }

    public String getCpf() {
        return cpf;
    }

    public void setEventId(UUID eventId) {
        this.eventId = eventId;
    }

    public void setCustomerId(UUID customerId) {
        this.customerId = customerId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}