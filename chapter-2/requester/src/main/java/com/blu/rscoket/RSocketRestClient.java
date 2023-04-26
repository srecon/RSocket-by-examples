package com.blu.rscoket;

import com.blu.rscoket.data.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.util.MimeType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
public class RSocketRestClient {

    private final RSocketRequester rsocketRequester;

    private static final String CLIENT = "Client";
    private static final String REQUEST = "Request";
    private static final String HOST = "localhost";
    private static final int PORT = 7007;

    @Autowired
    public RSocketRestClient (RSocketRequester.Builder rsocketRequesterBuilder){
        this.rsocketRequester = rsocketRequesterBuilder
                .tcp(HOST, PORT);
    }
    @GetMapping("/request-response")
    public Mono<Message> sendRequestResponse() {
        log.info("Sending request / response");
        return rsocketRequester
                .route("request-response")
                .metadata("some-custom-header-value", MimeType.valueOf("messaging/custom-header"))
                .data(new Message(CLIENT, REQUEST))
                .retrieveMono(Message.class);
    }
}
