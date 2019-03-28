package com.lvlivejp.foodsell.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "`t_product_category`")
public class ProductCategory {
    /**
     * 类目ID
     */
    @Id
    @Column(name = "category_id")
    @GeneratedValue(generator = "JDBC")
    private Integer categoryId;

    /**
     * 类名名称
     */
    @Column(name = "category_name")
    private String categoryName;

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
     * 获取类名名称
     *
     * @return category_name - 类名名称
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * 设置类名名称
     *
     * @param categoryName 类名名称
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
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