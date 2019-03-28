package com.lvlivejp.foodsell.service.impl;

import com.lvlivejp.foodsell.mapper.ProductCategoryMapper;
import com.lvlivejp.foodsell.model.ProductCategory;
import com.lvlivejp.foodsell.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryMapper productCategoryMapper;

    @Override
    public List<ProductCategory> findAll() {
        return productCategoryMapper.selectAll();
    }
}
