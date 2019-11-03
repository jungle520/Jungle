package com.jungle.RabbitMQ;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created by wangjiang on 2019/10/28.
 */
@Component
public class Sender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(String str) {
        String context = "hello " + new Date();
        System.out.println("Sender1 : " + context+str);
        this.rabbitTemplate.convertAndSend("hello", context);
    }






}
