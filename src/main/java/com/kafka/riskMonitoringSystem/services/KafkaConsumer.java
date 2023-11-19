package com.kafka.riskMonitoringSystem.services;

import com.kafka.riskMonitoringSystem.models.KafkaMessage;
import com.kafka.riskMonitoringSystem.repositories.KafkaMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class KafkaConsumer {
    @Autowired
    private KafkaMessageRepository kafkaMessageRepository;
    private final TelegramNotifier telegramNotifier;

    @Autowired
    public KafkaConsumer(TelegramNotifier telegramNotifier) {
        this.telegramNotifier = telegramNotifier;
    }

    @KafkaListener(topics = "quickstart-events", groupId = "myGroup")
    public void listen(String messageContent) {
        KafkaMessage message = new KafkaMessage();
        message.setMessage(messageContent);
        message.setTimestamp(LocalDateTime.now());

        kafkaMessageRepository.save(message);
        if (messageContent.equals("15000")) {
            telegramNotifier.sendNotification("Summary equals 15000");
        }

        System.out.println("Received message: " + messageContent);

    }
}
