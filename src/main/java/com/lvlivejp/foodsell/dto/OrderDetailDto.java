package com.lvlivejp.foodsell.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class OrderDetailDto {

    /**
     * 订单详情ID
     */
    @JsonProperty("detailId")
    private String orderDetailId;

    /**
     * 订单ID
     */
    @JsonProperty("orderId")
    private String orderId;

    /**
     * 商品ID
     */
    @JsonProperty("productId")
    private Integer productId;

    /**
     * 商品价格
     */
    private BigDecimal productPrice;

    /**
     * 商品图片
     */
    @JsonProperty("productIcon")
    private String productPic;

    /**
     * 商品名称
     */
    @Column(name = "product_name")
    private String productName;

    /**
     * 商品数量
     */
    @Column(name = "product_quantity")
    private Integer productQuantity;

}
