package com.lvlivejp.foodsell.controller.buyer;

import com.lvlivejp.foodsell.service.ProductInfoService;
import com.lvlivejp.foodsell.utils.ResultVOUtils;
import com.lvlivejp.foodsell.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/buyer/product")
public class ProductInfoController {

    @Autowired
    private ProductInfoService productInfoService;

    @GetMapping("/list/category")
//    public ResultVO findByCategory(@RequestParam("categoryId") Integer categoryId){
    public ResultVO findByCategory(Integer categoryId){
        return ResultVOUtils.success(productInfoService.findByCategory(categoryId));
    }

    @GetMapping("/list")
    public ResultVO findAll(){
        return ResultVOUtils.success(productInfoService.findAll());
    }

}
