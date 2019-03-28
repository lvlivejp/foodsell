package com.lvlivejp.foodsell.utils;

import com.lvlivejp.foodsell.enums.BaseEnum;
import com.lvlivejp.foodsell.enums.PayStatusEnum;
import sun.print.ServiceDialog;

public class EnumUtils {

    public static <T extends BaseEnum> T getEnumMsg(Integer code,Class<T> baseEnumClass ){
        for (T baseEnum : baseEnumClass.getEnumConstants()) {
            if(code == baseEnum.getCode()){
                return baseEnum;
            }
        }
        return null;
    }

    public static <T extends BaseEnum> T getEnumMsg(String code, Class<T> baseEnumClass) {
        return getEnumMsg(Integer.valueOf(code),baseEnumClass);
    }
}
