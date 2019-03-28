package com.lvlivejp.foodsell.service.impl;

import com.lvlivejp.foodsell.dto.ProductDetailDto;
import com.lvlivejp.foodsell.dto.ProductDto;
import com.lvlivejp.foodsell.form.OrderDetailForm;
import com.lvlivejp.foodsell.mapper.ProductCategoryMapper;
import com.lvlivejp.foodsell.mapper.ProductInfoMapper;
import com.lvlivejp.foodsell.model.OrderDetail;
import com.lvlivejp.foodsell.model.ProductCategory;
import com.lvlivejp.foodsell.model.ProductInfo;
import com.lvlivejp.foodsell.service.ProductInfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@CacheConfig(cacheNames = "product")
public class ProductInfoServiceImpl implements ProductInfoService {

    @Autowired
    private ProductInfoMapper productInfoMapper;

    @Autowired
    private ProductCategoryMapper productCategoryMapper;

    @Override
    public List<ProductInfo> findByCategory(Integer categoryId) {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setCategoryId(categoryId);
        return productInfoMapper.select(productInfo);
    }

    @Override
    @Cacheable(key = "#root.args[0]")
    public ProductInfo findOne(Integer productId) {
        return productInfoMapper.selectByPrimaryKey(productId);
    }

    @Override
    public List<ProductDto> findAll() {

        List<ProductDto> productDtos = new ArrayList<>();

        //查询所有上架商品
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductStatus("0");
        List<ProductInfo> productInfos = productInfoMapper.select(productInfo);

        Map<Integer,List<ProductDetailDto>> productMap = new HashMap<>();

        for (ProductInfo info : productInfos) {
            List<ProductDetailDto> productDetailDtos = productMap.get(info.getCategoryId()) == null ? new ArrayList<ProductDetailDto>() : productMap.get(info.getCategoryId());
            ProductDetailDto productDetailDto = new ProductDetailDto();
            BeanUtils.copyProperties(info,productDetailDto);
            productDetailDtos.add(productDetailDto);
            productMap.put(info.getCategoryId(),productDetailDtos);
        }

        //查询所有类目
        List<ProductCategory> productCategories = productCategoryMapper.selectAll();
        for (ProductCategory productCategory : productCategories) {
            ProductDto productDto= new ProductDto();
            BeanUtils.copyProperties(productCategory,productDto);
            productDto.setProductDetailDtos(productMap.get(productCategory.getCategoryId()));
            productDtos.add(productDto);
        }

        return productDtos;

    }

    @Override
    public void update(ProductInfo productInfo) {
        productInfoMapper.updateByPrimaryKey(productInfo);
    }

    @Override
    public void decreaseStock(OrderDetailForm orderDetailForm) {
        ProductInfo productInfo = productInfoMapper.selectByPrimaryKey(orderDetailForm.getProductId());
        productInfo.setProductStock(productInfo.getProductStock()-orderDetailForm.getProductQuantity());
        productInfoMapper.updateByPrimaryKey(productInfo);
    }

    @Override
    public void increaseStock(List<OrderDetail> orderDetailForms) {
        for (OrderDetail orderDetail : orderDetailForms) {
            ProductInfo productInfo = productInfoMapper.selectByPrimaryKey(orderDetail.getProductId());
            productInfo.setProductStock(productInfo.getProductStock()+orderDetail.getProductQuantity());
            productInfoMapper.updateByPrimaryKey(productInfo);
        }
    }

}
