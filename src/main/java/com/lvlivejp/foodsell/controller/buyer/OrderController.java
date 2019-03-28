package com.lvlivejp.foodsell.controller.buyer;

import com.lvlivejp.foodsell.dto.OrderDto;
import com.lvlivejp.foodsell.form.OrderForm;
import com.lvlivejp.foodsell.form.OrderSellForm;
import com.lvlivejp.foodsell.service.OrderService;
import com.lvlivejp.foodsell.utils.ResultVOUtils;
import com.lvlivejp.foodsell.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/buyer/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/create1")
    public ResultVO create(@RequestBody OrderForm orderForm) {
        orderService.create(orderForm);
        return ResultVOUtils.success();
    }

    @GetMapping("/detail")
    public ResultVO findOne(String openid,String orderId) {
        OrderDto orderDto = orderService.findOrder(orderId, openid);
        return ResultVOUtils.success(orderDto);
    }

    @PostMapping("/create")
    public ResultVO create1(OrderSellForm orderSellForm) {
        OrderDto orderDto = orderService.create(orderSellForm);

        Map<String,String> map=new HashMap<>();
        map.put("orderId",orderDto.getOrderId());

        return ResultVOUtils.success(map);
    }
}
