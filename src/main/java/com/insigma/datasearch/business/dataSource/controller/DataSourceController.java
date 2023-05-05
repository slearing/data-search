package com.insigma.datasearch.business.dataSource.controller;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.insigma.datasearch.entity.DataSource;
import com.insigma.datasearch.request.R;
import com.insigma.datasearch.business.dataSource.service.DataSourceService;
import com.insigma.datasearch.utils.validatedGroup.Insert;
import com.insigma.datasearch.utils.validatedGroup.Query;
import com.insigma.datasearch.utils.validatedGroup.Update;
import dto.DataSourceDto;
import io.swagger.annotations.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import vo.DropdownVo;

import java.util.List;

@RestController
@RequestMapping("/dataSource")
@Api(value = "数据库连接",authorizations = {@Authorization("syh")})
public class DataSourceController {
    private Log log = LogFactory.getLog(DataSourceController.class);
    @Autowired
    private DataSourceService service;

    @GetMapping(value = "/getDataSourceType")
    @ApiOperation(value="获取数据库类型",authorizations = {@Authorization("syh")})
    public R getDataSourceType(){
        List<DropdownVo> dataSourceType = service.getDataSourceType();

        return R.success("查询成功！",dataSourceType);
    }



    @PostMapping("/queryList")
    @ApiOperation(value = "列表查询",authorizations = {@Authorization("syh")})
    @ApiImplicitParams(value={
            @ApiImplicitParam(value = "name", name = "连接名称", type = "String"),
            @ApiImplicitParam(value = "type", name = "连接类型", type = "String"),
            @ApiImplicitParam(value = "pageNum", name = "页数", type = "Integer"),
            @ApiImplicitParam(value = "pageSize", name = "页大小", type = "Integer")
    })
    public R queryList(@RequestBody JSONObject data){
        Page<DataSource> page = service.queryList(data.getString("name"),data.getString("type"),data.getInteger("pageNum"),data.getInteger("pageSize"));

        return R.success("查询成功！",page);
    }


    @PostMapping("/insertDataSource")
    @ApiOperation(value="新增一个数据库连接",authorizations = {@Authorization("syh")})
    @ApiOperationSupport(ignoreParameters = {"dto.dataSourceId"})
    public R insertDataSource(@Validated(value = Insert.class) @RequestBody DataSourceDto dto){
        try {
            service.insertDataSource(dto);
        }catch (Exception e){
            log.error("插入报错",e);
            return R.fail("插入错误!");
        }
        return R.success("插入成功！");
    }


    @PostMapping("/updateDataSource")
    @ApiOperation(value="更新一个数据库连接",authorizations = {@Authorization("syh")})
    public R updateDataSource(@Validated(value = Update.class) @RequestBody DataSourceDto dto){
        try {
            service.updateDataSource(dto);
        }catch (Exception e){
            log.error("更新报错",e);
            return R.fail("更新错误!");
        }
        return R.success("更新成功！");
    }


    @PostMapping("/testDataSource")
    @ApiOperation(value="测试数据库连接",authorizations = {@Authorization("syh")})
    public R testDataSource(@Validated(value = Query.class) @RequestBody DataSourceDto dto){
        try {
            String s = service.testDataSource(dto);
            if(StrUtil.isNotBlank(s)){
                return R.fail(s);
            }
            return R.success("测试成功！");
        }catch (Exception e){
            log.error("插入报错",e);
            return R.fail("插入错误!");
        }

    }

}
