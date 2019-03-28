package com.lvlivejp.foodsell.controller.buyer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/weixin")
@Slf4j
public class WeiXinController {

    @GetMapping("/auth")
    public void auth(String code,String state){
      log.info(String.format("进入微信认证。code:%s,state:%s", code, state));

      String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wxe5dbdb2f3116ef9f&secret=56235aad644ddfea0b31ec41c8d42ab7&code="+code+"&grant_type=authorization_code";
        RestTemplate restTemplate = new RestTemplate();
        System.out.println(restTemplate.getForObject(url, String.class));
    }
}
