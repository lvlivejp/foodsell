package com.lvlivejp.foodsell.enums;

import lombok.Getter;

@Getter
public enum PayStatusEnum implements BaseEnum{

    NOT_PAY(0,"未支付"),
    SUCCESS(1,"支付成功"),
    ;

    private Integer code;
    private String msg;

    PayStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
