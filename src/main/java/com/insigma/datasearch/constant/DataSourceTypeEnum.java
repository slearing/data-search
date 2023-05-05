package com.insigma.datasearch.constant;

/**
 * 数据库连接类型枚举类
 */
public enum DataSourceTypeEnum {
    DM("DM","达梦"),
    MS("MS","MySql"),
    OR("OR","Oracle");

    private String type;
    private String desc;

    DataSourceTypeEnum(String type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
