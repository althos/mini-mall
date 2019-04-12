package com.athos.mall.system.domain;


import com.athos.mall.lang.anotation.Excel;
import com.athos.mall.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 字典数据表 sys_dict_data
 *
 * @author ruoyi
 */
@Getter
@Setter
public class DictData extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 字典编码
     */
    @Excel(name = "字典编码")
    private Long dictCode;

    /**
     * 字典排序
     */
    @Excel(name = "字典排序")
    private Long dictSort;

    /**
     * 字典标签
     */
    @Excel(name = "字典标签")
    private String dictLabel;

    /**
     * 字典键值
     */
    @Excel(name = "字典键值")
    private String dictValue;

    /**
     * 字典类型
     */
    @Excel(name = "字典类型")
    private String dictType;

    /**
     * 字典样式
     */
    @Excel(name = "字典样式")
    private String cssClass;

    /**
     * 表格字典样式
     */
    private String listClass;

    /**
     * 是否默认（Y是 N否）
     */
    @Excel(name = "是否默认", readConverterExp = "Y=是,N=否")
    private String isDefault;

    /**
     * 状态（0正常 1停用）
     */
    @Excel(name = "状态", readConverterExp = "0=正常,1=停用")
    private String status;

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("dictCode", getDictCode())
                .append("dictSort", getDictSort())
                .append("dictLabel", getDictLabel())
                .append("dictValue", getDictValue())
                .append("dictType", getDictType())
                .append("cssClass", getCssClass())
                .append("listClass", getListClass())
                .append("isDefault", getIsDefault())
                .append("status", getStatus())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("remark", getRemark())
                .toString();
    }
}
