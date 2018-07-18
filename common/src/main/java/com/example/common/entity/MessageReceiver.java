package com.example.common.entity;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
//@RabbitListener(queues = "Hello")
public class MessageReceiver {

//    @RabbitHandler
//    public void process(User hello){
//        System.out.println("Receiver::::::::" + hello);
//    }
}
