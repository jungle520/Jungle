package com.jungle.RabbitMQ;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.jungle.RabbitMQ.Reciever;
/**
 * Created by wangjiang on 2019/10/28.
 */
@Configuration
public class RabbitMQconfig {

    @Bean
    public Queue Queue() {
        return new Queue("hello");
    }

}
