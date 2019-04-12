package com.athos.mall.system.domain;


import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 用户和岗位关联 sys_user_post
 * 
 * @author ruoyi
 */
@Getter
@Setter
public class UserPost
{
    /** 用户ID */
    private Long userId;
    /** 岗位ID */
    private Long postId;


    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("userId", getUserId())
            .append("postId", getPostId())
            .toString();
    }
}
