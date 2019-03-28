package com.lvlivejp.foodsell.utils;

import com.lvlivejp.foodsell.enums.ResultEnum;
import com.lvlivejp.foodsell.exception.SellException;
import com.lvlivejp.foodsell.vo.ResultVO;

public class ResultVOUtils {

    public static ResultVO success(Object obj){
        return new ResultVO(ResultEnum.SUCCESS,obj);
    }

    public static ResultVO success(){
        return success(null);
    }

    public static ResultVO fail(SellException sellException){
        return new ResultVO(sellException.getErrorCode(),sellException.getMessage());
    }
}
