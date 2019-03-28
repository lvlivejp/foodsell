package com.lvlivejp.foodsell.mq.listener;

import com.lvlivejp.foodsell.model.Order;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;

/*适合于消息为string格式的消息，可以通过抽象类获取消息，统一打印日志
* 已经转化为Bean的消息，适合用切面来统一打印消息日志
* */
public abstract class BaseListener {
    @RabbitHandler
    public void handler(Order order) {
        exe(order);
    }

    abstract void exe(Object object);
}
