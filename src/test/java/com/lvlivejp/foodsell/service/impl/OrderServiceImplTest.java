package com.lvlivejp.foodsell.service.impl;
import com.lvlivejp.foodsell.form.OrderDetailForm;
import java.util.ArrayList;

import com.lvlivejp.foodsell.form.OrderForm;
import com.lvlivejp.foodsell.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderServiceImplTest {

    @Autowired
    OrderService orderService;
    @Test
    public void findOrderList() {
        System.out.println(orderService.findOrder("2018110109053016017207", "lvlivejp"));
    }

    @Test
    public void create(){
        OrderForm orderForm = new OrderForm();
        orderForm.setUserId("lvlivejp");
        orderForm.setBuyerName("吕");
        orderForm.setBuyerPhone("18711111123");
        orderForm.setBuyerAddress("上海");

        ArrayList<OrderDetailForm> orderDetailForms = new ArrayList<>();
        OrderDetailForm orderDetailForm = new OrderDetailForm();
        orderDetailForm.setProductId(2);
        orderDetailForm.setProductQuantity(1);
        orderDetailForms.add(orderDetailForm);

        orderDetailForm = new OrderDetailForm();
        orderDetailForm.setProductId(3);
        orderDetailForm.setProductQuantity(2);
        orderDetailForms.add(orderDetailForm);

        orderForm.setOrderDetailForms(orderDetailForms);

        orderService.create(orderForm);



    }
}