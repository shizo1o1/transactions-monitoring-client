package com.kafka.riskMonitoringSystem.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.bots.DefaultBotOptions;

@Configuration
public class TelegramConfig {

    @Bean
    DefaultBotOptions defaultBotOptions() {
        return new DefaultBotOptions();
    }
}
