package com.lvlivejp.foodsell.model;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "`t_product_info`")
@Data
public class ProductInfo implements Serializable {
    /**
     * 商品ID
     */
    @Id
    @Column(name = "product_id")
    @GeneratedValue(generator = "JDBC")
    private Integer productId;

    /**
     * 商品名称
     */
    @Column(name = "product_name")
    private String productName;

    /**
     * 商品库存
     */
    @Column(name = "product_stock")
    private Integer productStock;

    /**
     * 商品描述
     */
    @Column(name = "product_desc")
    private String productDesc;

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
     * 类目ID
     */
    @Column(name = "category_id")
    private Integer categoryId;

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
     * 商品状态
     **/
    private String productStatus;
    
    
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
     * 获取商品库存
     *
     * @return product_stock - 商品库存
     */
    public Integer getProductStock() {
        return productStock;
    }

    /**
     * 设置商品库存
     *
     * @param productStock 商品库存
     */
    public void setProductStock(Integer productStock) {
        this.productStock = productStock;
    }

    /**
     * 获取商品描述
     *
     * @return product_desc - 商品描述
     */
    public String getProductDesc() {
        return productDesc;
    }

    /**
     * 设置商品描述
     *
     * @param productDesc 商品描述
     */
    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
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
     * 获取类目ID
     *
     * @return category_id - 类目ID
     */
    public Integer getCategoryId() {
        return categoryId;
    }

    /**
     * 设置类目ID
     *
     * @param categoryId 类目ID
     */
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
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