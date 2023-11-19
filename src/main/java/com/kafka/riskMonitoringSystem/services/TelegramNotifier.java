package com.kafka.riskMonitoringSystem.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
public class TelegramNotifier extends TelegramLongPollingBot {

    @Value("${telegram.bot.token}")
    private String botToken;

    @Value("${telegram.chatId}")
    private String chatId;

    public TelegramNotifier(DefaultBotOptions botOptions) {
        super(botOptions);
    }

    @Override
    public String getBotUsername() {
        // Возвращаем имя бота
        return "Ваше_имя_бота";
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    @Override
    public void onUpdateReceived(Update update) {
        // Обработка входящих обновлений (не требуется для отправки уведомлений)
    }

    public void sendNotification(String message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(message);

        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace(); // Обработка ошибок
        }
    }
}

