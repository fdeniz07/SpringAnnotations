package com.tpe.service;

import com.tpe.domain.Message;
import com.tpe.repository.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component//bu classtan springin obje üretmesini istiyoruz.
public class MailService implements MessageService {

    //Spring bize, 3 türde Dependency Injection imkani sunuyor


    //1-field injection

  //  @Autowired //reponun objesini classa enjekte ediyor.
  //  @Qualifier("fileRepository")
  // private Repo repo;



    //2-setter injection
//
//    private Repo repo;
//
//    @Autowired
//    @Qualifier("fileRepository")
//    public void setRepo(Repo repo){
//        this.repo=repo;
//    }

    //3-Constructor Injection (Daha cok tercih ediliyor)
    //Daha güvenli, daha anlasilir, test etmek daha kolaydir.
    private Repo repo;

    @Autowired
    public MailService(@Qualifier("fileRepository") Repo repo) {
        this.repo = repo;
    }



    @Override
    public void sendMessage(Message message) {
        System.out.println("Ben bir mail servisiyim. Mesajınız:" + message.getMessage());
    }

    @Override
    public void saveMessage(Message message) {
        //reponun metodu icin objesine ihtiyacimiz var
        repo.save(message);
    }
}
