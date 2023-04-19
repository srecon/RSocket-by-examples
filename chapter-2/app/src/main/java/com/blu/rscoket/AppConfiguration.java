package com.blu.rscoket;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@EnableConfigurationProperties
@Configuration
//@ConfigurationProperties("application.properties")
@ConfigurationProperties("spring")
public class AppConfiguration {

    @Value("${spring.rsocket.server.port}")
    private int port;

    public int getPort(){
        return this.port;
    }
}
