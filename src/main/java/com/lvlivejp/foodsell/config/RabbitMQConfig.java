package com.lvlivejp.foodsell.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    /*将bean转为json格式*/
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public Queue sellWechatMsgQueue(){
        return new Queue("sell.wechat.msg");
    }

    @Bean
    public Queue sellSmsQueue(){
        return new Queue("sell.sms");
    }

    @Bean
    FanoutExchange sellFanoutExchange() {
        return new FanoutExchange("sellFanoutExchange");
    }

    @Bean
    Binding bindingExchangeMessageWechat(Queue sellWechatMsgQueue, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(sellWechatMsgQueue).to(fanoutExchange);
    }

    @Bean
    Binding bindingExchangeMessageSms(Queue sellSmsQueue, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(sellSmsQueue).to(fanoutExchange);
    }
}
