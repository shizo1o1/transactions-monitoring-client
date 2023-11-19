package com.kafka.riskMonitoringSystem.repositories;


import com.kafka.riskMonitoringSystem.models.KafkaMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KafkaMessageRepository extends JpaRepository<KafkaMessage, Long> {

}
