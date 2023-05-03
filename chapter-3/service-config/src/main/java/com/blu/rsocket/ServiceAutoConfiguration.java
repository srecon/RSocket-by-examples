package com.blu.rsocket;

import com.alibaba.rsocket.invocation.RSocketRemoteServiceBuilder;
import com.alibaba.rsocket.upstream.UpstreamManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
@ComponentScan(basePackages = {"com.alibaba.rsocket"})

public class ServiceAutoConfiguration {

    @Bean
    public MessageService messageService(@Autowired UpstreamManager upstreamManager){

        return RSocketRemoteServiceBuilder
                .client(MessageService.class)
                .upstreamManager(upstreamManager)
                .build();

    }
}
