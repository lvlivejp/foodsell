package com.lvlivejp.foodsell.service;

import com.github.pagehelper.PageInfo;
import com.lvlivejp.foodsell.dto.OrderDto;
import com.lvlivejp.foodsell.form.OrderForm;
import com.lvlivejp.foodsell.form.OrderSellForm;

public interface OrderService {

    //下单
    public OrderDto create(OrderForm orderForm);

    //下单
    public OrderDto create(OrderSellForm orderSellForm);

    //支付
    void pay(String orderId);

    //查询个人订单
    OrderDto findOrder(String orderId, String userId);

    //查询订单列表
    PageInfo<OrderDto> findOrderList(Integer pageNum, Integer pageSize);

    //取消订单
    void cancel(String orderId);

    //卖家端查询订单
    OrderDto findOrder(String orderId);

    //卖家端完结订单
    void finish(String orderId);
}
