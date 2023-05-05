package com.insigma.datasearch.business.dataSource.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.insigma.datasearch.entity.DataSource;
import org.apache.ibatis.annotations.Mapper;

/**
 * 数据库连接的mapper
 */
@Mapper
public interface DataSourceMapper extends BaseMapper<DataSource> {
}
