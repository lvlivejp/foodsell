package com.lvlivejp.foodsell.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@ConfigurationProperties(prefix="foodsell")
@Data
public class FoodSellConfig {
    
    /**
     * Session超时时间
     **/
    public Long sessionTimeout;

    /**
     * Redis超时时间
     **/
    public Long redisReadTimeout;
    
    
}
