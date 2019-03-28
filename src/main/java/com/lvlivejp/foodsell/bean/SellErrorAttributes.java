package com.lvlivejp.foodsell.bean;

import com.alibaba.fastjson.JSONObject;
import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;

import java.util.HashMap;
import java.util.Map;

@Component
//自定义错误属性
public class SellErrorAttributes extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(RequestAttributes requestAttributes, boolean includeStackTrace) {
        /*原始错误属性值*/
        Map<String, Object> errorAttributes = super.getErrorAttributes(requestAttributes, includeStackTrace);
        /*自定义错误属性值*/
//        errorAttributes.put("resultVO",requestAttributes.getAttribute("resultVO",0));
        /* 可以将自定义的返回json在这里格式化输出*/
//        errorAttributes = JSONObject.parseObject(requestAttributes.getAttribute("resultVOJson", 0).toString(), HashMap.class);
        return errorAttributes;
    }
}
