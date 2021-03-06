package com.tuyoo.hello.queue;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Sender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        String context = String.format("hello %s", new Date());
        System.out.println(String.format("Sender: %s", context));
        this.rabbitTemplate.convertAndSend("hello", context);
    }
}
