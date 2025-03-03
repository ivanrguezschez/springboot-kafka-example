package com.irs.consumer.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumerListener {

    private Logger LOGGER = LoggerFactory.getLogger(KafkaConsumerListener.class);

    @KafkaListener(topics = { "springbootkafkaexample-topic" }, groupId = "springbootkafkaexample-groupId")
    public void listener(String message) {
        LOGGER.info("Mensaje recibido: {}", message);
    }
}
