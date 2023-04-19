package com.blu.rscoket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

import javax.annotation.PostConstruct;

@SpringBootApplication
@Slf4j
public class RsocketServer {

    //@Value("${spring.rsocket.server.port}")
    //private int port;
    //@Autowired
    //private static AppConfiguration appConfiguration;

    public static void main(String[] args) {

        SpringApplication.run (RsocketServer.class, args);
        //log.info ("RSocket Server will be started on port: " + appConfiguration.getPort());
    }

}
