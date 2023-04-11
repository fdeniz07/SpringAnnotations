package com.tpe;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration//bu classta config olacak
@ComponentScan("com.tpe")//bu packagedaki componentları tara, default: "com.tpe"
public class AppConfiguration {


}
