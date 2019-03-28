package com.lvlivejp.foodsell.controller.buyer;

import com.lvlivejp.foodsell.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pay")
public class PayController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/create")
    public String create(String openid,String orderId,String returnUrl){
        orderService.pay(orderId);
        return "redirect:"+returnUrl;
    }
}
