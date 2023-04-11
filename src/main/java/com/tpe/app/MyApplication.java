package com.tpe.app;

import com.tpe.AppConfiguration;
import com.tpe.domain.Message;
import com.tpe.service.MailService;
import com.tpe.service.MessageService;
import com.tpe.service.SmsService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyApplication {
    public static void main(String[] args) {

        Message message=new Message();
        message.setMessage("Spring ile uygulama geliştirmek HARİKA:)");

        //config classını oku
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(AppConfiguration.class);
        //config classındaki component scan ile tüm componentleri tarayacak
        //her component tan bir tane bean oluştur, contexte hazırda bekletecek


       // MessageService service=context.getBean(MailService.class);
      //  MessageService service=context.getBean(MessageService.class);//Spring akıllı
        //service.sendMessage(message);//newleme yapmadık
                                     //spring container dan rica ettik, bize hazır getirdi. IoC

       // MessageService service=context.getBean(SmsService.class);
        MessageService service=context.getBean("smsservice",MessageService.class);
        service.sendMessage(message);

        //interface i implemente eden  birden fazla component ile işaretlenmiş class varsa
        //hangisini alması gerektiğini belirtmemiz gerekir.

        context.close();//contextten obje isteyemeyiz.


    }
}
