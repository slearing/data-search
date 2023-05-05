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
 * 模块表
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@TableName("DATA_MOULD")
public class DataMould {
    //唯一标识
    @TableId
    private String dataMouldId;
    //模块名
    private String dataMouldName;
    //名称字段
    private String dataMouldNameField;
    //是否开启定时器  0 不开启  1开启
    private String dataMouldIsOpenCros;
    //CROS表达式
    private String dataMouldUpdateType;
    //同步的方式 1增量  2全量
    private String dataMouldIsCreateView;
    //数据库连接主键
    private String dataSourceId;
    //创建时间
    @TableField(updateStrategy = FieldStrategy.IGNORED)
    private Date dataMouldCreateTime;
    //更新时间
    private Date dataMouldUpdateTime;
    //状态  1 有效  0 无效
    private String dataMouldStatus;
}
