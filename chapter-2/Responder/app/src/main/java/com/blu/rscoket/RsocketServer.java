package com.blu.rscoket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.rsocket.RSocketServerAutoConfiguration;


@SpringBootApplication
@Slf4j
//@EnableAutoConfiguration(exclude={RSocketServerAutoConfiguration.class})
public class RsocketServer {

    public static void main(String[] args) {

        SpringApplication.run (RsocketServer.class, args);
        //log.info ("RSocket Server will be started on port: " + appConfiguration.getPort());
    }

}
