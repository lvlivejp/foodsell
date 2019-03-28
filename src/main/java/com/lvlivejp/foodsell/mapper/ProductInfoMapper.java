package com.lvlivejp.foodsell.mapper;

import com.lvlivejp.foodsell.model.ProductInfo;

/**
* 通用 Mapper 代码生成器
*
* @author mapper-generator
*/
public interface ProductInfoMapper extends tk.mybatis.mapper.common.Mapper<ProductInfo> {

    ProductInfo findByProductId(Integer id);
}




