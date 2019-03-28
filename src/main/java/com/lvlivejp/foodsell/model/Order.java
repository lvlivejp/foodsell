package com.lvlivejp.foodsell.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "`t_order`")
public class Order {
    /**
     * 订单ID
     */
    @Id
    @Column(name = "order_id")
    private String orderId;

    /**
     * 用户ID
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 收件人
     */
    @Column(name = "buyer_name")
    private String buyerName;

    /**
     * 收件人电话
     */
    @Column(name = "buyer_phone")
    private String buyerPhone;

    /**
     * 收件地址
     */
    @Column(name = "buyer_address")
    private String buyerAddress;

    /**
     * 订单金额
     */
    @Column(name = "order_amount")
    private BigDecimal orderAmount;

    /**
     * 订单状态
     */
    @Column(name = "order_status")
    private String orderStatus;

    /**
     * 付款状态
     */
    @Column(name = "pay_status")
    private String payStatus;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 获取订单ID
     *
     * @return order_id - 订单ID
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * 设置订单ID
     *
     * @param orderId 订单ID
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
     * 获取用户ID
     *
     * @return user_id - 用户ID
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置用户ID
     *
     * @param userId 用户ID
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取收件人
     *
     * @return buyer_name - 收件人
     */
    public String getBuyerName() {
        return buyerName;
    }

    /**
     * 设置收件人
     *
     * @param buyerName 收件人
     */
    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    /**
     * 获取收件人电话
     *
     * @return buyer_phone - 收件人电话
     */
    public String getBuyerPhone() {
        return buyerPhone;
    }

    /**
     * 设置收件人电话
     *
     * @param buyerPhone 收件人电话
     */
    public void setBuyerPhone(String buyerPhone) {
        this.buyerPhone = buyerPhone;
    }

    /**
     * 获取收件地址
     *
     * @return buyer_address - 收件地址
     */
    public String getBuyerAddress() {
        return buyerAddress;
    }

    /**
     * 设置收件地址
     *
     * @param buyerAddress 收件地址
     */
    public void setBuyerAddress(String buyerAddress) {
        this.buyerAddress = buyerAddress;
    }

    /**
     * 获取订单金额
     *
     * @return order_amount - 订单金额
     */
    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    /**
     * 设置订单金额
     *
     * @param orderAmount 订单金额
     */
    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    /**
     * 获取订单状态
     *
     * @return order_status - 订单状态
     */
    public String getOrderStatus() {
        return orderStatus;
    }

    /**
     * 设置订单状态
     *
     * @param orderStatus 订单状态
     */
    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    /**
     * 获取付款状态
     *
     * @return pay_status - 付款状态
     */
    public String getPayStatus() {
        return payStatus;
    }

    /**
     * 设置付款状态
     *
     * @param payStatus 付款状态
     */
    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取修改时间
     *
     * @return update_time - 修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置修改时间
     *
     * @param updateTime 修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}