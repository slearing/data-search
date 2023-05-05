package com.insigma.datasearch.business.dataSource.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.insigma.datasearch.entity.DataSource;
import dto.DataSourceDto;
import vo.DropdownVo;

import java.util.List;

/**
 * 数据库连接的service
 */
public interface DataSourceService {
    /**
     * 获取数据库类型列表
     * @return
     */
    List<DropdownVo> getDataSourceType();

    /**
     * 列表查询
     * @param name 连接名称
     * @param type 连接类型
     * @param pageNum 页数
     * @param pageSize 页大小
     * @return
     */
    Page<DataSource> queryList(String name, String type, Integer pageNum, Integer pageSize);

    /**
     * 插入一个数据库连接
     * @param dto
     */
    void insertDataSource(DataSourceDto dto);

    /**
     * 更新数据库连接
     * @param dto
     */
    void updateDataSource(DataSourceDto dto);

    /**
     * 测试是否可连接
     * @param dto
     */
    String testDataSource(DataSourceDto dto);
}
