package com.blu.rsocket.responder;

import com.alibaba.rsocket.RSocketService;
import com.blu.rsocket.MessageService;
import com.blu.rsocket.dto.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Slf4j
@RSocketService(serviceInterface = MessageService.class)
@Service
public class MessageServiceImpl implements MessageService{

    private static final String SERVER = "Server";
    private static final String RESPONSE = "Response";

    @Override
    public Mono<Message> getMessage() {
        log.info("Message Invoked on Responder!");
        return Mono.just(new Message(SERVER, RESPONSE));
    }
}
