package com.lvlivejp.foodsell.enums;

import lombok.Getter;

@Getter
public enum ResultEnum implements BaseEnum {

    SUCCESS(0,"成功"),
    PRODUCT_NOT_EXIST(10,"商品信息有误"),
    PRODUCT_STOCK_ERROR(20,"商品库存不足"),
    ORDER_NOT_EXIST(30,"订单不存在"),
    PAY_STATUS_ERROR(31,"付款状态不正确"),
    ORDER_STATUS_ERROR(32,"订单状态不正确"),
    ;

    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
