package com.tpe;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

@Configuration//bu classta config olacak
@ComponentScan("com.tpe")//bu packagedaki componentları tara, default: "com.tpe"
public class AppConfiguration {

    @Bean //Bean annotation ile ben bu nesneden bir tane bean olusturup IOC containere ekleyeyim, birisinin ihtiyaci oldugunda cagirir kullanirim der.
    public Random random(){
        return new Random();
    }

}
