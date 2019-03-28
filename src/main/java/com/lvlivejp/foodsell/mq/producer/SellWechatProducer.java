package com.lvlivejp.foodsell.mq.producer;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class SellWechatProducer {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    @Qualifier("sellWechatMsgQueue")
    Queue queue;

    public void send(Object object){
        rabbitTemplate.convertAndSend(queue.getName(),object);
    }
}
