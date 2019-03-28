package com.lvlivejp.foodsell.controller.seller;

import com.github.pagehelper.PageInfo;
import com.lvlivejp.foodsell.dto.OrderDto;
import com.lvlivejp.foodsell.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/seller/order")
public class SellerOrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/list")
    public ModelAndView orderList(@RequestParam(defaultValue="1") Integer pageNum,
                                   @RequestParam(defaultValue="10") Integer pageSize){
        PageInfo<OrderDto> orderList = orderService.findOrderList(pageNum, pageSize);
        ModelAndView modelAndView= new ModelAndView();
        modelAndView.setViewName("order/list");
        modelAndView.addObject("orderDtoList",orderList);
        return modelAndView;
    }

    @GetMapping("/cancel/{orderId}")
    public String cancel(@PathVariable("orderId") String orderId){
        orderService.cancel(orderId);
        return "redirect:/seller/order/list";
    }

    @GetMapping("/detail/{orderId}")
    public ModelAndView detail(@PathVariable("orderId") String orderId){
        OrderDto orderDto = orderService.findOrder(orderId);
        ModelAndView modelAndView= new ModelAndView();
        modelAndView.setViewName("order/detail");
        modelAndView.addObject("orderDto", orderDto);
        return modelAndView;
    }

    @GetMapping("/finish/{orderId}")
    public String finish(@PathVariable("orderId") String orderId){
        orderService.finish(orderId);
        return "redirect:/seller/order/list";
    }

}
