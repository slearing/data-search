package com.insigma.datasearch.entity;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 数据库连接实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@TableName("DATA_SOURCE")
public class DataSource {
    //唯一标识
    @TableId
    private String dataSourceId;
    //名称
    private String dataSourceName;
    //驱动类名
    private String dataSourceDriver;
    //URL
    private String dataSourceUrl;
    //用户名
    private String dataSourceUsername;
    //密码
    private String dataSourcePassword;
    //数据库类型（MS-MySql、DM-达梦、Oracle-OR）
    private String dataSourceType;
    //创建时间
    @TableField(updateStrategy = FieldStrategy.IGNORED)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date dataSourceCreateTime;
    //更新时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date dataSourceUpdateTime;
    //状态  1 有效  0 无效
    private String dataSourceStatus;
}
