package com.lvlivejp.foodsell.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDto {

    /**
     * 类目ID
     */
    @JsonProperty("type")
    private Integer categoryId;

    /**
     * 类名名称
     */
    @JsonProperty("name")
    private String categoryName;

    /**
     * 商品明细
     */
    @JsonProperty("foods")
    private List<ProductDetailDto> productDetailDtos;

}
