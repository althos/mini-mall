package com.athos.mall.shop.domain;


import com.athos.mall.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 商品分类表 pflm_category
 *
 * @author ruoyi
 * @date 2019-03-05
 */
@Setter
@Getter
public class Category extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**  */
    private Integer id;
    /**
     * 分类名称
     */
    private String name;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 父级编号
     */
    private Integer pid;



    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("name", getName())
                .append("createTime", getCreateTime())
                .append("pid", getPid())
                .toString();
    }
}
