package com.blu.rsocket.responder;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


@SpringBootApplication
public class RsocketBrokerResponder {

    public static void main(String[] args) {

        SpringApplication.run(RsocketBrokerResponder.class, args);

//        ApplicationContext appContext = new AnnotationConfigApplicationContext("com.blu.rsocket");
//        MessageService  msgService = appContext.getBean(MessageService.class);
//        System.out.println("TRY again and Again: "+ msgService.getMessage());
    }
}
