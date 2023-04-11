package com.tpe.app;

import com.tpe.domain.Message;
import com.tpe.service.MailService;
import com.tpe.service.MessageService;
import com.tpe.service.SmsService;

public class MyApplication {
    public static void main(String[] args) {

        Message message = new Message();
        message.setMessage("Siparişiniz kargoya verildi.");

        //mesajı maille kullanıcıya gönder
//        MailService mailService=new MailService();
//        mailService.sendMessage(message);

        //vazgeçtik, hala sms kullanan var:)
//        SmsService smsService=new SmsService();
//        smsService.sendMessage(message);

        //bu böyle gitmez..interface çözüm olablir mi??
//        MessageService service=new MailService();//veya diğeri
//        service.sendMessage(message);


        //run timeda servisi belirlemek istersek
        MessageService service = null;
        String serviceName = "MailService";

        if (args.length > 0) {
            serviceName = args[0];
        }

        if (serviceName.equalsIgnoreCase("MailService")) {
            service = new MailService();
        } else if (serviceName.equalsIgnoreCase("SmsService")) {
            service = new SmsService();
        }
        service.sendMessage(message);


    }
}
