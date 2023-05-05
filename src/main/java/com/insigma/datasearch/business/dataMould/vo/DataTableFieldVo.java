package com.insigma.datasearch.business.dataMould.vo;

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
 * 模块表字段Vo
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DataTableFieldVo {
    //唯一标识
    private String dataTableFieldId;
    //表唯一标识
    private String dataMouldItemId;
    //字段名称
    private String dataTableFieldName;
    //字段备注
    private String dataTableFieldDesc;
    //状态
    private String dataTableFieldStatus;
}
