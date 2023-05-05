package com.insigma.datasearch.utils;

import cn.hutool.core.util.IdUtil;

import java.util.Date;

/**
 * 时间工具类
 */
public class DateUtil {
    public static String getId(){
        return cn.hutool.core.date.DateUtil.format(new Date(),"yyyyMMddHHmmss")+ IdUtil.simpleUUID();
    }
}
