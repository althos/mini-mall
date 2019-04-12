package com.athos.mall.system.domain;


import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 用户和角色关联 sys_user_role
 * 
 * @author ruoyi
 */
@Getter
@Setter
public class UserRole
{
    /** 用户ID */
    private Long userId;
    
    /** 角色ID */
    private Long roleId;

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("userId", getUserId())
            .append("roleId", getRoleId())
            .toString();
    }
}
