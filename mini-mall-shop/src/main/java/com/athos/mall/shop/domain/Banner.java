package com.athos.mall.shop.domain;


import com.athos.mall.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 广告banner表 pflm_banner
 *
 * @author ruoyi
 * @date 2019-02-27
 */
@Setter
@Getter
public class Banner extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**  */
    private Integer id;
    /**
     * banner名称
     */
    private String name;
    /**
     * 图片地址
     */
    private String img;
    /**
     * 创建日期
     */
    private Date createTime;
    /**
     * 商品编号
     */
    private Integer pid;
    private Integer type;


    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("name", getName())
                .append("img", getImg())
                .append("createTime", getCreateTime())
                .append("pid", getPid())
                .append("type", getType())
                .toString();
    }
}
