package com.lvlivejp.foodsell.mq.producer;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class SellFanoutProducer {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    @Qualifier("sellFanoutExchange")
    FanoutExchange fanoutExchange;

    public void send(Object object){
        rabbitTemplate.convertAndSend(fanoutExchange.getName(),"",object);
    }
}
