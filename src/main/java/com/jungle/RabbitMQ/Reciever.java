package com.jungle.RabbitMQ;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by wangjiang on 2019/10/28.
 */

@Component
@RabbitListener(queues = "hello")
public class Reciever {



    @RabbitHandler
    public void process(String hello) {
        System.out.println("Receiever:"+hello);
    }
}
