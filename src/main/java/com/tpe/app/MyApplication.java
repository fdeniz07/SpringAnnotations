package com.tpe.app;

import com.tpe.AppConfiguration;
import com.tpe.domain.Message;
import com.tpe.service.MailService;
import com.tpe.service.MessageService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Random;

public class MyApplication {
    public static void main(String[] args) {

        Message message = new Message();
        message.setMessage("Spring ile uygulama geliştirmek HARİKA:)");

        //config classını oku
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
        //config classındaki component scan ile tüm componentleri tarayacak
        //her component tan bir tane bean oluştur, contexte hazırda bekletecek
        //bean istedigimizde icerisindeki gerekli bagimliliklari enjekte ederek verir.

        // MessageService service=context.getBean(MailService.class);
        //  MessageService service=context.getBean(MessageService.class);//Spring akıllı
        //service.sendMessage(message);//newleme yapmadık
        //spring container dan rica ettik, bize hazır getirdi. IoC

        // MessageService service=context.getBean(SmsService.class);
//        MessageService service = context.getBean("smsservice", MessageService.class);
//        service.sendMessage(message);

        //interface i implemente eden  birden fazla component ile işaretlenmiş class varsa
        //hangisini alması gerektiğini belirtmemiz gerekir.


        MessageService service2 = context.getBean(MailService.class);
        service2.sendMessage(message);
        service2.saveMessage(message); //dbrepo'yu yenilemedik
        //enjekte edilecek obje secenegi birden fazla ise @Qualifier("fileRepository") ile belirtilmelidir.


        //Random random = new Random(); --> Spring bizim icin olustursun
        Random random = context.getBean(Random.class);
        System.out.println(random.nextInt(100));



        // Spring'de bean'lerin default scope: singleton dur.
        //Singleton : Tüm uygulama icin sadece tek bir bean olusturulur.
        //Prototype : her obje istendiginde yeni bir bean olusturulur.


        MessageService service3 = context.getBean(MailService.class);
        MessageService service4 = context.getBean(MailService.class);

        if (service3 ==service4){
            System.out.println("Ayni referansli objeler");
            System.out.println(service3);
            System.out.println(service4);
        }else
        {
            System.out.println("Farkli referansli objeler");
            System.out.println(service3);
            System.out.println(service4);
        }



        context.close();//contextten obje isteyemeyiz. Bean'ler sonlandirilir. getBean ile bean talep edemeyiz.


    }
}
