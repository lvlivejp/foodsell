package com.lvlivejp.foodsell.form;

import lombok.Data;

import java.util.List;

@Data
public class OrderForm {
    /**
     * 用户ID
     */
    private String userId;

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
     * 订单详情
     */
    private List<OrderDetailForm> orderDetailForms;


}
