package com.util;

import java.text.SimpleDateFormat;

/**
 * Description:
 * 线程安全的SimpleDateFormat，每个线程有一个副本
 * @author zhouzhongyi
 * Date: 2018/7/28 17:06
 */
public class DateFormatUtil {
    //根据需求进行更换
    private static final String pattern = "yyyy-MM-dd:HH-mm-ss" ;

    private static final ThreadLocal<SimpleDateFormat> localSimpleDateFormat = new ThreadLocal<>() ;

    public static SimpleDateFormat synchronizedSimpleDateFormat() {
        if(localSimpleDateFormat.get() == null) {
            localSimpleDateFormat.set(new SimpleDateFormat(pattern));
        }
        return localSimpleDateFormat.get() ;
    }

}
