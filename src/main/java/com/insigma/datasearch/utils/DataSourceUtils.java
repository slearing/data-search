package com.insigma.datasearch.utils;


import com.insigma.datasearch.constant.DataSourceConstant;
import com.insigma.datasearch.constant.DataSourceTypeEnum;
import com.insigma.datasearch.business.dataSource.dto.DataSourceDto;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * 数据库连接工具类
 */
public class DataSourceUtils {
    private static Log log = LogFactory.getLog(DataSourceUtils.class);

    public static JdbcTemplate getJdbcTemplate(DataSourceDto dataSource){
        // 创建数据源对象
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName(dataSource.getDataSourceDriver());
        driverManagerDataSource.setUrl(dataSource.getDataSourceUrl());
        driverManagerDataSource.setUsername(dataSource.getDataSourceUsername());
        driverManagerDataSource.setPassword(dataSource.getDataSourcePassword());

        return new JdbcTemplate(driverManagerDataSource);
    }

    /**
     * 测试数据库连接
     * @param dto
     * @return
     */
    public static String testCollection(DataSourceDto dto){
        JdbcTemplate jdbcTemplate = getJdbcTemplate(dto);

        String sql = "";
        if(DataSourceTypeEnum.DM.getType().equals(dto.getDataSourceType()) || DataSourceTypeEnum.OR.getType().equals(dto.getDataSourceType())){
            sql = DataSourceConstant.DEFAULT_DM_TEST_SQL;
        }

        try {
            jdbcTemplate.query(sql, (rch) -> {
                System.out.println("aaaa");
            });
        }catch (Exception e){
            log.error("测试出错",e);
            return e.getMessage();
        }

        return null;

    }

}
