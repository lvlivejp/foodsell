package com.lvlivejp.foodsell.form;

import lombok.Data;

@Data
public class OrderDetailForm {

    /**
     * 商品ID
     */
    private Integer productId;

    /**
     * 商品数量
     */
    private Integer productQuantity;
}
