package com.lvlivejp.foodsell.controller.buyer;

import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URLEncoder;

@RequestMapping("/wechat")
@Slf4j
@Controller
public class WeChatController {

    @Autowired
    private WxMpService wxMpService;

    @GetMapping("/authorize")
    public String auth(String returnUrl){
        //获取微信code后的回调地址
        String url = "http://lvlivejpsell.natapp1.cc/sell/wechat/userInfo";
        //第一步：用户同意授权，获取code
        //生成获取code的Url
        String redirectUrl = wxMpService.oauth2buildAuthorizationUrl(url, WxConsts.OAuth2Scope.SNSAPI_BASE,
                URLEncoder.encode(returnUrl));
        log.info(String.format("redirectUrl：%s", redirectUrl));
        //访问url
        return "redirect:"+redirectUrl;
    }

    //获取code后，回调该请求
    @GetMapping("/userInfo")
    public String getUserInfo(String code,String state){
        log.info(String.format("进入微信认证。code:%s,state:%s", code, state));
        //第二步：通过code换取网页授权access_token
        try {
            WxMpOAuth2AccessToken wxMpOAuth2AccessToken = wxMpService.oauth2getAccessToken(code);
            log.info(String.format("获取到openId：%s", wxMpOAuth2AccessToken.getOpenId()));
            return "redirect:" + state+"?openid="+wxMpOAuth2AccessToken.getOpenId();
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
        return "error";
    }
}
