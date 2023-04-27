package com.blu.rsocket.services;

import com.alibaba.rsocket.RSocketService;
import com.blu.rsocket.dto.Message;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@RSocketService(serviceInterface = MessageService.class)
@Service
public class MessageServiceImpl implements MessageService{

    private static final String SERVER = "Server";
    private static final String RESPONSE = "Response";

    @Override
    public Mono<Message> getMessage() {
        return Mono.just(new Message(SERVER, RESPONSE));
    }
}
