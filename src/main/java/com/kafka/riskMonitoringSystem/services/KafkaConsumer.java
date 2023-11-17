package com.kafka.riskMonitoringSystem.services;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "quickstart-events", groupId = "myGroup")
    public void listen(String message) {
        System.out.println("Received message: " + message);
    }
}
