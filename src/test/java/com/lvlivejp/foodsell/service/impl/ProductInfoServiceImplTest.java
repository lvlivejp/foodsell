package com.lvlivejp.foodsell.service.impl;

import com.lvlivejp.foodsell.model.ProductInfo;
import com.lvlivejp.foodsell.service.OrderService;
import com.lvlivejp.foodsell.service.ProductInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProductInfoServiceImplTest {
    @Autowired
    private ProductInfoService productInfoService;

    @Autowired
    private OrderService orderService;


    @Autowired
    RedisTemplate redisTemplate;

    @Test
    public void findOne() {
        productInfoService.findOne(2);
//        redisTemplate.opsForValue().set("abcd".getBytes(),"sfsdfs");
        System.out.println((ProductInfo)redisTemplate.opsForValue().get("product:2"));
//        System.out.println(redisTemplate.getExpire("product:2").intValue());
    }

    @Test
    public void findOrderOne() {
        orderService.findOrder("2018110109053016017207","");
//        redisTemplate.opsForValue().set("abcd".getBytes(),"sfsdfs");
        System.out.println((ProductInfo)redisTemplate.opsForValue().get("product:2"));
//        System.out.println(redisTemplate.getExpire("product:2").intValue());
    }
}