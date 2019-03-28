package com.lvlivejp.foodsell.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Data
public class ProductDetailDto {

    /**
     * 商品ID
     */
    @JsonProperty("id")
    private Integer productId;

    /**
     * 商品名称
     */
    @JsonProperty("name")
    private String productName;

    /**
     * 商品描述
     */
    @JsonProperty("description")
    private String productDesc;

    /**
     * 商品价格
     */
    @JsonProperty("price")
    private BigDecimal productPrice;

    /**
     * 商品图片
     */
    @JsonProperty("icon")
    private String productPic;

}
