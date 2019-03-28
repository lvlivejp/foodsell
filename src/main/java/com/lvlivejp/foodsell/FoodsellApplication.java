package com.lvlivejp.foodsell;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.lvlivejp.foodsell.mapper")
@EnableCaching
@EnableRabbit
public class FoodsellApplication {

    public static void main(String[] args) {
        SpringApplication.run(FoodsellApplication.class, args);
    }
}
