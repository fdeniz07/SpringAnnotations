package com.tpe.service;

import com.tpe.domain.Message;

public class MailService implements MessageService {

    public void sendMessage(Message message) {
        System.out.println("Ben bir Mail servisiyim. Mesajınız: " + message.getMessage());
    }
}
