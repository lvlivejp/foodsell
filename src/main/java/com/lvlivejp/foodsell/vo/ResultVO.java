package com.lvlivejp.foodsell.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.lvlivejp.foodsell.enums.ResultEnum;
import lombok.Data;

@Data
//忽略值为null的字段
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultVO {


    public ResultVO(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultVO(ResultEnum resultEnum, Object data) {
        this.code = resultEnum.getCode();
        this.msg = resultEnum.getMsg();
        this.data = data;
    }

    public ResultVO(ResultEnum resultEnum) {
        this.code = resultEnum.getCode();
        this.msg = resultEnum.getMsg();
    }



    /**
     * 返回码
     **/
    public Integer code;

    /**
     * 返回描述
     **/
    public String msg;

    /**
     * 业务数据
     */
    public Object data;


}
