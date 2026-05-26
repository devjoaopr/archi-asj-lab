package com.service.customer.config;

import com.service.sharedevents.CustomerCreatedEvent;
import org.springframework.boot.kafka.autoconfigure.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

@Configuration
public class KafkaProducerConfig {
    @Bean
    ProducerFactory<String, CustomerCreatedEvent> producerFactory(KafkaProperties kafkaProperties) {
        return new DefaultKafkaProducerFactory<>(
                kafkaProperties.buildProducerProperties()
        );
    }

    @Bean
    KafkaTemplate<String, CustomerCreatedEvent> kafkaTemplate(ProducerFactory<String, CustomerCreatedEvent> producerFactory) {
        return new KafkaTemplate<>(producerFactory);
    }
}