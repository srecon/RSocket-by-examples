package com.blu.rsocket.services;

import com.alibaba.rsocket.invocation.RSocketRemoteServiceBuilder;
import com.alibaba.rsocket.upstream.UpstreamManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class ServiceAutoConfiguration {
    @Bean
    public MessageService messageService(UpstreamManager upstreamManager){

        return RSocketRemoteServiceBuilder
                .client(MessageService.class)
                .upstreamManager(upstreamManager)
                .build();

    }
}
