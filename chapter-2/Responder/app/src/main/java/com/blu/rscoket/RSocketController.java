package com.blu.rscoket;

import com.blu.rscoket.data.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@Controller
@Slf4j
public class RSocketController {

    private static final String SERVER = "Server";
    private static final String RESPONSE = "Response";

    @MessageMapping("request-response")
    Message requestResponse(Message request) {
        log.info("Received request-response request: {}", request);
        // create a single Message and return it
        return new Message(SERVER, RESPONSE);
    }
}
