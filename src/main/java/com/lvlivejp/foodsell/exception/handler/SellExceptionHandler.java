package com.lvlivejp.foodsell.exception.handler;

import com.alibaba.fastjson.JSONObject;
import com.lvlivejp.foodsell.exception.SellException;
import com.lvlivejp.foodsell.utils.ResultVOUtils;
import com.lvlivejp.foodsell.vo.ResultVO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class SellExceptionHandler {

    /*转发到error处理请求，进行自适应*/
    @ExceptionHandler(SellException.class)
    public String SellException(SellException sellException, HttpServletRequest request){
        Map<String,Object> map = new HashMap<>();
        /*定义http响应状态*/
        request.setAttribute("javax.servlet.error.status_code",500);
        /*将自定义异常信息加入request中，error处理请求会从request获取异常信息*/
        request.setAttribute("resultVO",ResultVOUtils.fail(sellException));
        request.setAttribute("resultVOJson", JSONObject.toJSONString(ResultVOUtils.fail(sellException)));
        //转发到/error
        return "forward:/error";
    }

    /*直接返回响应数据，无法自适应是页面或json请求*/
//    @ExceptionHandler(SellException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultVO SellException(SellException sellException){
        return ResultVOUtils.fail(sellException);
    }
}
