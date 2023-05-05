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
 * 模块的明细表
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@TableName("DATA_MOULD_ITEM")
public class DataMouldItem {
    //唯一标识
    @TableId
    private String dataMouldItemId;
    //查询sql
    private String dataMouldItemSql;
    //表名
    private String dataMouldTable;
    //表注释
    private String dataMouldTableDesc;
    //关联条件
    private String dataMouldItemJoin;
    //表类型 1主表 2 明细表
    private String dataMouldType;
    //模块唯一标识
    private String dataMouldId;
    //创建时间
    @TableField(updateStrategy = FieldStrategy.IGNORED)
    private Date dataMouldItemCreateTime;
    //更新时间
    private Date dataMouldItemUpdateTime;
    //状态  1 有效  0 无效
    private String dataMouldItemStatus;
}

