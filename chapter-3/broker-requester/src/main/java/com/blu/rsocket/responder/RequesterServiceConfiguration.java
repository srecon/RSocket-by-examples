package com.blu.rsocket.responder;

import com.alibaba.rsocket.loadbalance.LoadBalancedRSocket;
import com.alibaba.rsocket.upstream.UpstreamManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.messaging.rsocket.RSocketStrategies;
import org.springframework.util.MimeType;
import com.alibaba.spring.boot.rsocket.hessian.HessianDecoder;
import com.alibaba.spring.boot.rsocket.hessian.HessianEncoder;


@Configuration
public class RequesterServiceConfiguration {

    @Bean
    public RSocketRequester rsocketRequester(UpstreamManager upstreamManager) {
        LoadBalancedRSocket loadBalancedRSocket = upstreamManager.findBroker().getLoadBalancedRSocket();
        RSocketStrategies rSocketStrategies = RSocketStrategies.builder()
                .encoder(new HessianEncoder())
                .decoder(new HessianDecoder())
                .build();
        return RSocketRequester.wrap(loadBalancedRSocket,
                MimeType.valueOf("application/x-hessian"),
                MimeType.valueOf("message/x.rsocket.composite-metadata.v0"),
                rSocketStrategies);
    }
}
