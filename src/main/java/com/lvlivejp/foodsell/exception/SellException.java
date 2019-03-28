package com.lvlivejp.foodsell.exception;

import com.lvlivejp.foodsell.enums.ResultEnum;
import lombok.Data;

@Data
public class SellException extends RuntimeException {

    private Integer errorCode;

    public SellException(Integer errorCode,String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.errorCode = resultEnum.getCode();
    }
}
