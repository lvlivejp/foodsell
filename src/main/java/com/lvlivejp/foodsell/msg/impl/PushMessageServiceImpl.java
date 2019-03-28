package com.lvlivejp.foodsell.msg.impl;

import com.lvlivejp.foodsell.enums.OrderStatusEnum;
import com.lvlivejp.foodsell.model.Order;
import com.lvlivejp.foodsell.msg.PushMessageService;
import com.lvlivejp.foodsell.utils.EnumUtils;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.ServiceMode;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
public class PushMessageServiceImpl implements PushMessageService {

    @Autowired
    WxMpService wxMpService;

    @Override
    public void orderStatus(Order order) {
        WxMpTemplateMessage templateMessage = WxMpTemplateMessage.builder()
                .toUser(order.getUserId())
                .templateId("ni6WNXCbsjjAdf7EGkdiaHBgQlOE7Z4FIFYNAkfR5qg")
                .build();

        List<WxMpTemplateData> data = Arrays.asList(
                new WxMpTemplateData("first", "亲，订单状态变更","#173177"),
                new WxMpTemplateData("orderId", order.getOrderId()),
                new WxMpTemplateData("orderStatus", EnumUtils.getEnumMsg(order.getOrderStatus(), OrderStatusEnum.class).getMsg()),
                new WxMpTemplateData("orderAmount", order.getOrderAmount().toString()),
                new WxMpTemplateData("remark", "欢迎再次光临"));
        templateMessage.setData(data);
        try {
            wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage);
        } catch (WxErrorException e) {
            log.error("微信消息发送失败：",e);
        }
    }
}
