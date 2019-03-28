package com.lvlivejp.foodsell;

import com.lvlivejp.foodsell.mapper.ProductCategoryMapper;
import com.lvlivejp.foodsell.mapper.ProductInfoMapper;
import com.lvlivejp.foodsell.model.ProductCategory;
import com.lvlivejp.foodsell.model.ProductInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FoodsellApplicationTests {

    @Autowired
    private ProductCategoryMapper productCategoryDao;
    @Autowired
    private ProductInfoMapper productInfoDao;

    @Test
    public void contextLoads() {
        ProductCategory order = new ProductCategory();
        order.setCategoryName("1111");
        order.setCreateTime(new Date());
        order.setUpdateTime(new Date());

        productCategoryDao.insert(order);
        System.out.println(order.getCategoryId());

        System.out.println(productCategoryDao.selectByPrimaryKey(order.getCategoryId()));

    }

    @Test
    @Transactional
    public void findByProductIdTest(){
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductDesc("");
        System.out.println(productInfoDao.select(productInfo));
//        System.out.println(productInfoDao.findByProductId(2));
//        System.out.println(productInfoDao.findByProductId(2));
    }

}
