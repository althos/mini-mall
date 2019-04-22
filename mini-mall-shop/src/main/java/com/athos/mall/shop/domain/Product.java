package com.athos.mall.shop.domain;


import com.athos.mall.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 产品表 pflm_product
 *
 * @author ruoyi
 * @date 2019-02-27
 */
@Setter
@Getter
public class Product extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**  */
    private Integer id;
    /**
     * 创建日期
     */
    private Date createTime;
    /**
     * 商品标题
     */
    private String title;
    /**
     * 现价
     */
    private String newprice;
    /**
     * 原价
     */
    private String oldprice;
    /**
     * 详情
     */
    private String details;
    /**
     * 商品logo
     */
    private String img;
    /**
     * 状态id
     */
    private Integer status;

    private Integer cid;

    private String category;

    private Integer recommend;

    private Long deptId;

    private Long userId;


    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("createTime", getCreateTime())
                .append("title", getTitle())
                .append("newprice", getNewprice())
                .append("oldprice", getOldprice())
                .append("details", getDetails())
                .append("img", getImg())
                .append("status", getStatus())
                .append("cid", getCid())
                .append("category", getCategory())
                .append("recommend", getRecommend())
                .toString();
    }
}
