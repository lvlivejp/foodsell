package com.lvlivejp.foodsell.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "`t_order_detail`")
public class OrderDetail {
    /**
     * 订单详情ID
     */
    @Id
    @Column(name = "order_detail_id")
    private String orderDetailId;

    /**
     * 订单ID
     */
    @Column(name = "order_id")
    private String orderId;

    /**
     * 商品ID
     */
    @Column(name = "product_id")
    private Integer productId;

    /**
     * 商品价格
     */
    @Column(name = "product_price")
    private BigDecimal productPrice;

    /**
     * 商品图片
     */
    @Column(name = "product_pic")
    private String productPic;

    /**
     * 商品名称
     */
    @Column(name = "product_name")
    private String productName;

    /**
     * 商品数量
     */
    @Column(name = "product_quantity")
    private Integer productQuantity;

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
     * 获取订单详情ID
     *
     * @return order_detail_id - 订单详情ID
     */
    public String getOrderDetailId() {
        return orderDetailId;
    }

    /**
     * 设置订单详情ID
     *
     * @param orderDetailId 订单详情ID
     */
    public void setOrderDetailId(String orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

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
     * 获取商品ID
     *
     * @return product_id - 商品ID
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * 设置商品ID
     *
     * @param productId 商品ID
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * 获取商品价格
     *
     * @return product_price - 商品价格
     */
    public BigDecimal getProductPrice() {
        return productPrice;
    }

    /**
     * 设置商品价格
     *
     * @param productPrice 商品价格
     */
    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    /**
     * 获取商品图片
     *
     * @return product_pic - 商品图片
     */
    public String getProductPic() {
        return productPic;
    }

    /**
     * 设置商品图片
     *
     * @param productPic 商品图片
     */
    public void setProductPic(String productPic) {
        this.productPic = productPic;
    }

    /**
     * 获取商品名称
     *
     * @return product_name - 商品名称
     */
    public String getProductName() {
        return productName;
    }

    /**
     * 设置商品名称
     *
     * @param productName 商品名称
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * 获取商品数量
     *
     * @return product_quantity - 商品数量
     */
    public Integer getProductQuantity() {
        return productQuantity;
    }

    /**
     * 设置商品数量
     *
     * @param productQuantity 商品数量
     */
    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
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