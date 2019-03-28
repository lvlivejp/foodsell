package com.lvlivejp.foodsell.msg;

import com.lvlivejp.foodsell.model.Order;

public interface PushMessageService {

    public void orderStatus(Order order);
}
