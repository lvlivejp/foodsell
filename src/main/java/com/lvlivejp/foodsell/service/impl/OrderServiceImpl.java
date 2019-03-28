package com.lvlivejp.foodsell.service.impl;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.lvlivejp.foodsell.dto.OrderDetailDto;
import com.lvlivejp.foodsell.dto.OrderDto;
import com.lvlivejp.foodsell.enums.OrderStatusEnum;
import com.lvlivejp.foodsell.enums.PayStatusEnum;
import com.lvlivejp.foodsell.enums.ResultEnum;
import com.lvlivejp.foodsell.exception.SellException;
import com.lvlivejp.foodsell.form.OrderDetailForm;
import com.lvlivejp.foodsell.form.OrderForm;
import com.lvlivejp.foodsell.form.OrderSellForm;
import com.lvlivejp.foodsell.mapper.OrderDetailMapper;
import com.lvlivejp.foodsell.mapper.OrderMapper;
import com.lvlivejp.foodsell.model.Order;
import com.lvlivejp.foodsell.model.OrderDetail;
import com.lvlivejp.foodsell.model.ProductInfo;
import com.lvlivejp.foodsell.mq.producer.SellWechatProducer;
import com.lvlivejp.foodsell.service.OrderService;
import com.lvlivejp.foodsell.service.ProductInfoService;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ProductInfoService productInfoService;
    @Autowired
    private OrderDetailMapper orderDetailMapper;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private SellWechatProducer sellWechatProducer;

    @Override
    @Transactional
    public OrderDto create(OrderForm orderForm) {

        List<OrderDetailDto> orderDetailDtos = new ArrayList<>();
        BigDecimal allPrice = BigDecimal.ZERO;
        OrderDetail orderDetail;
        String orderId = DateFormatUtils.format(new Date(),"yyyyMMddHHmmss")+RandomStringUtils.random(8,false,true);
        for (OrderDetailForm orderDetailForm : orderForm.getOrderDetailForms()) {
            //1.获取商品和价格
            ProductInfo productInfo = productInfoService.findOne(orderDetailForm.getProductId());
            if(productInfo == null){
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            //2.检查库存是否足够
            if(orderDetailForm.getProductQuantity().compareTo(productInfo.getProductStock())>0){
                throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
            }

            //计算总价
            allPrice = allPrice.add(productInfo.getProductPrice().multiply(new BigDecimal(orderDetailForm.getProductQuantity())));

            //生成订单子表
            orderDetail = new OrderDetail();
            String detailId = DateFormatUtils.format(new Date(),"yyyyMMddHHmmss")+RandomStringUtils.random(8,false,true);
            orderDetail.setOrderDetailId(detailId);
            orderDetail.setOrderId(orderId);
            orderDetail.setProductId(productInfo.getProductId());
            orderDetail.setProductPrice(productInfo.getProductPrice());
            orderDetail.setProductPic(productInfo.getProductPic());
            orderDetail.setProductName(productInfo.getProductName());
            orderDetail.setProductQuantity(orderDetailForm.getProductQuantity());
            orderDetail.setCreateTime(new Date());
            orderDetail.setUpdateTime(new Date());
            orderDetailMapper.insert(orderDetail);

            OrderDetailDto orderDetailDto = new OrderDetailDto();
            BeanUtils.copyProperties(orderDetail,orderDetailDto);
            orderDetailDtos.add(orderDetailDto);

            //3.减库存
            productInfoService.decreaseStock(orderDetailForm);
        }
        //3.生成主表订单
        Order order = new Order();
        BeanUtils.copyProperties(orderForm,order);
        order.setOrderId(orderId);
        order.setCreateTime(new Date());
        order.setOrderStatus(OrderStatusEnum.NEW.getCode().toString());
        order.setPayStatus(PayStatusEnum.NOT_PAY.getCode().toString());
        order.setOrderAmount(allPrice);
        orderMapper.insert(order);

        OrderDto orderDto = new OrderDto();
        BeanUtils.copyProperties(order,orderDto);
        orderDto.setOrderDetailDtos(orderDetailDtos);
        return orderDto;
    }

    @Override
    @Transactional
    public OrderDto create(OrderSellForm orderSellForm) {
        OrderForm orderForm = new OrderForm();
        orderForm.setUserId(orderSellForm.getOpenid());
        orderForm.setBuyerName(orderSellForm.getName());
        orderForm.setBuyerPhone(orderSellForm.getPhone());
        orderForm.setBuyerAddress(orderSellForm.getAddress());
        List<OrderDetailForm> objects = JSONObject.parseArray(orderSellForm.getItems(),OrderDetailForm.class);
        orderForm.setOrderDetailForms(objects);

        return create(orderForm);
    }

    @Override
    public void pay(String orderId) {
        Order order = orderMapper.selectByPrimaryKey(orderId);
        if(order == null){
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }

        if(!PayStatusEnum.NOT_PAY.getCode().toString().equals(order.getPayStatus())){
            throw new SellException(ResultEnum.PAY_STATUS_ERROR);
        }
        order.setPayStatus(PayStatusEnum.SUCCESS.getCode().toString());
        orderMapper.updateByPrimaryKey(order);
    }

    @Override
    @Cacheable(cacheNames = "order",key = "#root.args[0]")
    public OrderDto findOrder(String orderId, String userId) {
        Order order = new Order();
        order.setOrderId(orderId);
        order.setUserId(userId);
        Order orderResult = orderMapper.selectOne(order);
        if(orderResult == null){
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }

        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderId(orderId);
        List<OrderDetail> orderDetails = orderDetailMapper.select(orderDetail);

        OrderDto orderDto = new OrderDto();
        ArrayList<OrderDetailDto> orderDetailDtos = new ArrayList<>();
        BeanUtils.copyProperties(orderResult,orderDto);
        for (OrderDetail detail : orderDetails) {
            OrderDetailDto orderDetailDto = new OrderDetailDto();
            BeanUtils.copyProperties(detail,orderDetailDto);
            orderDetailDtos.add(orderDetailDto);
        }
        orderDto.setOrderDetailDtos(orderDetailDtos);
        return orderDto;
    }

    @Override
    public PageInfo<OrderDto> findOrderList(Integer pageNum, Integer pageSize) {
        List<OrderDto> orderDtolist= new ArrayList<>();
        PageHelper.startPage(pageNum,pageSize);
        List<Order> orders = orderMapper.selectAll();
        PageInfo<Order> orderPageInfo = new PageInfo<>(orders);
        PageInfo<OrderDto> orderDtoPageInfo = new PageInfo<>();
        for (Order order : orders) {
            OrderDto orderDto = new OrderDto();
            BeanUtils.copyProperties(order,orderDto);
            orderDtolist.add(orderDto);
        }
        BeanUtils.copyProperties(orderPageInfo,orderDtoPageInfo);
        orderDtoPageInfo.setList(orderDtolist);
        return orderDtoPageInfo;
    }

    @Override
    @Transactional
    public void cancel(String orderId) {
        Order order = new Order();
        order.setOrderId(orderId);
        order.setOrderStatus(OrderStatusEnum.NEW.getCode().toString());
        Order orderResult = orderMapper.selectOne(order);
        if(orderResult == null){
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }

        //更新状态
        orderResult.setOrderStatus(OrderStatusEnum.CANCLE.getCode().toString());
        orderResult.setPayStatus(PayStatusEnum.NOT_PAY.getCode().toString());
        orderMapper.updateByPrimaryKey(orderResult);


        //返还库存
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderId(orderId);
        List<OrderDetail> orderDetails = orderDetailMapper.select(orderDetail);
        productInfoService.increaseStock(orderDetails);
        //TODO 调用退款接口

        //TODO 微信消息发MQ
        sellWechatProducer.send(orderResult);
    }

    @Override
    public OrderDto findOrder(String orderId) {
        return this.findOrder(orderId,"");
    }

    @Override
    @Transactional
    public void finish(String orderId) {
        Order order = orderMapper.selectByPrimaryKey(orderId);
        if(Integer.valueOf(order.getOrderStatus()) != OrderStatusEnum.NEW.getCode()){
            throw new SellException(ResultEnum.ORDER_STATUS_ERROR);
        }
        if(Integer.valueOf(order.getPayStatus()) != PayStatusEnum.SUCCESS.getCode()){
            throw new SellException(ResultEnum.PAY_STATUS_ERROR);
        }

        order.setOrderStatus(OrderStatusEnum.FINISHED.getCode().toString());
        orderMapper.updateByPrimaryKey(order);

        //TODO 微信消息发MQ

    }

    //TODO druid数据源，登录，websocket，秒杀
}
