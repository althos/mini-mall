package com.athos.mall.system.domain;


import com.athos.mall.lang.anotation.Excel;
import com.athos.mall.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.util.Date;

/**
 * 工序表 pflm_process
 *
 * @author ruoyi
 * @date 2019-02-21
 */
@Getter
@Setter
public class Process extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**  */
    private Integer id;
    /**
     * 工票号
     */
    @Excel(name = "工票号")
    private String ticketNo;
    /**
     * 工序号
     */
    @Excel(name = "工序号")
    private String processNo;
    /**  */
    @Excel(name = "创建日期", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    /**
     * 员工号
     */
    @Excel(name = "员工号")
    private String employeeNo;
    /**
     * 公分
     */
    @Excel(name = "工分")
    private Integer score;
    /**
     * 备注
     */
    @Excel(name = "备注")
    private String remark;


    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("processNo", getProcessNo())
                .append("createTime", getCreateTime())
                .append("employeeNo", getEmployeeNo())
                .append("score", getScore())
                .append("remark", getRemark())
                .append("ticketNo", getTicketNo())
                .toString();
    }
}
