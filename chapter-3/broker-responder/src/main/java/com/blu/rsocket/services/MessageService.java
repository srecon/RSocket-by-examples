package com.blu.rsocket.services;

import com.alibaba.rsocket.RSocketServiceInterface;
import com.blu.rsocket.dto.Message;
import reactor.core.publisher.Mono;

@RSocketServiceInterface
public interface MessageService {
    Mono<Message> getMessage();
}
