package com.lvlivejp.foodsell.service;

import com.lvlivejp.foodsell.dto.ProductDto;
import com.lvlivejp.foodsell.form.OrderDetailForm;
import com.lvlivejp.foodsell.model.OrderDetail;
import com.lvlivejp.foodsell.model.ProductInfo;

import java.util.List;

public interface ProductInfoService {

    List<ProductInfo> findByCategory(Integer categoryId);

    ProductInfo findOne(Integer productId);

    List<ProductDto> findAll();

    void update(ProductInfo productInfo);

    //减库存
    void decreaseStock(OrderDetailForm orderDetailForm);

    void increaseStock(List<OrderDetail> orderDetailForms);
}
