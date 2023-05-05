package com.insigma.datasearch.entity;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 模块表字段
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("DATA_TABLE_FIELD")
public class DataTableField {
    //唯一标识
    @TableId
    private String dataTableFieldId;
    //表唯一标识
    private String dataMouldItemId;
    //字段名称
    private String dataTableFieldName;
    //字段备注
    private String dataTableFieldDesc;
    //创建时间
    @TableField(updateStrategy = FieldStrategy.IGNORED)
    private Date dataTableFieldCreateTime;
    //更新时间
    private Date dataTableFieldUpdateTime;
    //状态
    private String dataTableFieldStatus;
}
