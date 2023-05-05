package com.insigma.datasearch.business.dataSource.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.insigma.datasearch.business.dataSource.service.DataSourceService;
import com.insigma.datasearch.constant.DataSourceTypeEnum;
import com.insigma.datasearch.constant.PageConstant;
import com.insigma.datasearch.entity.DataSource;
import com.insigma.datasearch.business.dataSource.mapper.DataSourceMapper;
import com.insigma.datasearch.utils.DataSourceUtils;
import com.insigma.datasearch.utils.DateUtil;
import dto.DataSourceDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vo.DropdownVo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 数据库连接的service实现类
 */
@Service
public class DataSourceServiceImpl implements DataSourceService {
    @Autowired
    private DataSourceMapper mapper;

    /**
     * 获取数据库类型列表
     * @return
     */
    @Override
    public List<DropdownVo> getDataSourceType() {
        List<DropdownVo> dropdownVoList = new ArrayList<>();
        dropdownVoList.add(DropdownVo.builder().codeValue(DataSourceTypeEnum.DM.getType()).codeName(DataSourceTypeEnum.DM.getDesc()).build());
        dropdownVoList.add(DropdownVo.builder().codeValue(DataSourceTypeEnum.MS.getType()).codeName(DataSourceTypeEnum.MS.getDesc()).build());
        dropdownVoList.add(DropdownVo.builder().codeValue(DataSourceTypeEnum.OR.getType()).codeName(DataSourceTypeEnum.OR.getDesc()).build());
        return dropdownVoList;
    }

    /**
     * 列表查询
     * @param name 连接名称
     * @param type 连接类型
     * @param pageNum
     * @param pageSize 页大小
     * @return
     */
    @Override
    public Page<DataSource> queryList(String name, String type, Integer pageNum, Integer pageSize) {
        QueryWrapper<DataSource> wrapper = new QueryWrapper();
        if(StrUtil.isNotBlank(name)){
            wrapper.like("DATA_SOURCE_NAME",name);
        }
        if (StrUtil.isNotBlank(type)){
            wrapper.eq("DATA_SOURCE_TYPE",type);
        }

        pageNum =  pageNum == null ? PageConstant.DEFAULT_PAGE_NUM : pageNum;
        pageSize =  pageSize == null ? PageConstant.DEFAULT_PAGE_SIZE : pageSize;
        Page<DataSource> page = new Page<>(pageNum,pageSize);

        return mapper.selectPage(page,wrapper);
    }



    /**
     * 新增数据库连接
     * @param dto
     */
    @Override
    public void insertDataSource(DataSourceDto dto) {
        DataSource dataSource = new DataSource();
        BeanUtils.copyProperties(dto,dataSource);

        Date date = new Date();
        dataSource.setDataSourceId(DateUtil.getId());
        dataSource.setDataSourceCreateTime(date);
        dataSource.setDataSourceUpdateTime(date);
        mapper.insert(dataSource);
    }

    /**
     * 更新数据库连接
     * @param dto
     */
    @Override
    public void updateDataSource(DataSourceDto dto) {
        DataSource dataSource = new DataSource();
        BeanUtils.copyProperties(dto,dataSource);

        Date date = new Date();
        dataSource.setDataSourceUpdateTime(date);

        mapper.updateById(dataSource);
    }

    /**
     * 测试数据库连接
     * @param dto
     */
    @Override
    public String testDataSource(DataSourceDto dto) {
        return DataSourceUtils.testCollection(dto);
    }
}
