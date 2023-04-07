package com.blu.rscoket;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class RsocketServer {

    @Value("${spring.rsocket.server.port}")
    private int port;

    public static void main(String[] args) {

        SpringApplication.run (RsocketServer.class, args);
        log.info ("RSocket Server will be started on port: " + new RsocketServer().port);
    }

}
