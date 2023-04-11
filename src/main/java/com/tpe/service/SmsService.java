package com.tpe.service;

import com.tpe.domain.Message;

public class SmsService implements MessageService {

    @Override
    public void sendMessage(Message message) {
        System.out.println("Ben bir SMS servisiyim. Mesajınız: " + message.getMessage());
    }
}
