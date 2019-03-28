package com.lvlivejp.foodsell.mq.listener;

import com.lvlivejp.foodsell.model.Order;
import com.lvlivejp.foodsell.msg.PushMessageService;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "sell.wechat.msg")
public class SellWechatListener{

    @Autowired
    PushMessageService pushMessageService;

    @RabbitHandler
    public void handler(Order order) {
        pushMessageService.orderStatus(order);
    }

}
