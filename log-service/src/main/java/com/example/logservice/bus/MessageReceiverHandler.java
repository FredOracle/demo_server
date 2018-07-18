package com.example.logservice.bus;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "Hello")
public class MessageReceiverHandler {


    @RabbitHandler
    public void process(String hello){
        System.out.println("Receiver:::::::::::::::::" + hello);
    }
}
