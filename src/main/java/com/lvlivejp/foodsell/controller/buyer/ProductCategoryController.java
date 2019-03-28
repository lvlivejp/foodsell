package com.lvlivejp.foodsell.controller.buyer;

import com.lvlivejp.foodsell.model.ProductCategory;
import com.lvlivejp.foodsell.service.ProductCategoryService;
import com.lvlivejp.foodsell.utils.ResultVOUtils;
import com.lvlivejp.foodsell.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/productcategory")
public class ProductCategoryController {

    @Autowired
    private ProductCategoryService productCategoryService;

    @GetMapping("/list")
    public ResultVO findAll(){
        List<ProductCategory> all = productCategoryService.findAll();
        return ResultVOUtils.success(all);
    }

}
