package com.insigma.datasearch.business.dataSource.dto;

import com.insigma.datasearch.utils.validatedGroup.Insert;
import com.insigma.datasearch.utils.validatedGroup.Query;
import com.insigma.datasearch.utils.validatedGroup.Update;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotBlank;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel("数据库连接的dto对象")
public class DataSourceDto {
    @ApiModelProperty(value = "唯一标识",required = true,dataType = "String")
    @NotBlank(message="唯一标识不能为空！",groups = {Update.class})
    private String dataSourceId;

    @ApiModelProperty(value = "名称",required = true,dataType = "String")
    @NotBlank(message="名称不能为空！",groups = {Insert.class,Update.class})
    private String dataSourceName;

    @ApiModelProperty(value = "驱动类名",required = true,dataType = "String")
    @NotBlank(message="驱动类名不能为空！",groups = {Insert.class,Update.class, Query.class})
    private String dataSourceDriver;

    @ApiModelProperty(value = "URL",required = true,dataType = "String")
    @NotBlank(message="URL不能为空！",groups = {Insert.class,Update.class, Query.class})
    private String dataSourceUrl;

    @ApiModelProperty(value = "用户名",required = true,dataType = "String")
    @NotBlank(message="用户名不能为空！",groups = {Insert.class,Update.class, Query.class})
    private String dataSourceUsername;

    @ApiModelProperty(value = "密码",required = true,dataType = "String, Query.class")
    @NotBlank(message="密码不能为空！",groups = {Insert.class,Update.class})
    private String dataSourcePassword;

    @ApiModelProperty(value = "数据库类型（MS-MySql、DM-达梦、Oracle-OR）",required = true,dataType = "String")
    @NotBlank(message="数据库类型不能为空！",groups = {Insert.class,Update.class, Query.class})
    private String dataSourceType;

    @ApiModelProperty(value = "状态  1 有效  0 无效",required = true,dataType = "String")
    @NotBlank(message="状态不能为空！",groups = {Insert.class,Update.class})
    private String dataSourceStatus;
}
