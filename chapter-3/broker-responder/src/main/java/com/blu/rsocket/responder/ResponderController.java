package com.blu.rsocket.responder;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResponderController {

    @RequestMapping("/")
    public String index(){
       return "Rsocket Broker responder is up and running!";
    }
}
