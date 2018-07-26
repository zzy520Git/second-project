package com.jd.secondproject.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Description:
 * 自定义参数绑定
 * @author zhouzhongyi
 * @date 2018/7/26 22:41
 */
public class CustomDateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String s) {
        //实现将日期串转成日期类型(格式是yyyy-MM-dd HH:mm:ss)
        //注意，SimpleDateFormat不是线程安全的，需纠正
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return simpleDateFormat.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
