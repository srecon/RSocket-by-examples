package com.blu.rsocket.responder;


import com.blu.rsocket.MessageService;
import com.blu.rsocket.dto.Message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.util.MimeType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
public class RequesterRestController {

    @Autowired
    private MessageService messageService;

    @Autowired
    private RSocketRequester rSocketRequester;

    @RequestMapping("/")
    public String ping (){
        return "Requester i running!";
    }

    @RequestMapping("/getMessage")
    public Mono<Message> getMessage() {
        log.info("Invoked requester method: getMessage!");
        return messageService.getMessage();
    }
    @GetMapping("/getMessageByRequester")
    public Mono<Message> getMessageByRequester(){
        log.info("Invoked requester method: getMessageByRequester!");
        if( rSocketRequester != null){
            log.info("DEBUG!!" + rSocketRequester.rsocket().availability());
        }
        return rSocketRequester
                .route("com.blu.rsocket.MessageService.getMessage")
                .metadata("some-custom-header-value", MimeType.valueOf("messaging/custom-header"))
                .retrieveMono(Message.class);
    }
}
