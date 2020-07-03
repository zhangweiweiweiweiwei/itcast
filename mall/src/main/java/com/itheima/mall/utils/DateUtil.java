package com.itheima.mall.utils;

import java.util.Date;
import java.text.SimpleDateFormat;
//封装为工具类
public class DateUtil {
    public static String date2String(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String regisTime = sdf.format(date);
        return regisTime;
    }
}
