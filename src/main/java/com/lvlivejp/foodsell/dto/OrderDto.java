package com.lvlivejp.foodsell.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.lvlivejp.foodsell.enums.OrderStatusEnum;
import com.lvlivejp.foodsell.enums.PayStatusEnum;
import com.lvlivejp.foodsell.utils.Date2LongSerializer;
import com.lvlivejp.foodsell.utils.EnumUtils;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class OrderDto {

    /**
     * 订单ID
     */
    private String orderId;

    /**
     * 收件人
     */
    private String buyerName;

    /**
     * 收件人电话
     */
    private String buyerPhone;

    /**
     * 收件地址
     */
    private String buyerAddress;

    /**
     * 订单金额
     */
    private BigDecimal orderAmount;

    /**
     * 订单状态
     */
    private String orderStatus;

    /**
     * 付款状态
     */
    private String payStatus;

    /**
     * 微信openid
     **/
    @JsonProperty("buyerOpenid")
    public String userId;

    /**
     * 订单详情
     */
    @JsonProperty("orderDetailList")
    private List<OrderDetailDto> orderDetailDtos = new ArrayList<>();

    /**
     * 创建时间
     */
    //自定义json序列化方法
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    public String getPayStatusEnum(){
        return EnumUtils.getEnumMsg(this.payStatus,PayStatusEnum.class).getMsg();
    }

    public String getOrderStatusEnum(){
        return EnumUtils.getEnumMsg(this.orderStatus, OrderStatusEnum.class).getMsg();
    }
}
