package com.main;

import com.util.DateFormatUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Description:
 *
 * @author zhouzhongyi
 * Date: 2018/7/28 22:06
 */
public class DateFormatMain {
    public static void main(String[] args) {
        new MyThread().start();
        new MyThread().start();
        SimpleDateFormat sdf = DateFormatUtil.synchronizedSimpleDateFormat() ;
        System.out.println(sdf.format(new Date()));
        try {
            //像这种不符合规范的日期字符串也可以转换成功，不报错。不用满足两位数MM或者dd等
            Date dt = sdf.parse("1999-2-22:25-61-9") ;
            System.out.println("Date:" + dt.toString());
        } catch (ParseException e) {
            System.out.println("输入字符串格式不对");
            e.printStackTrace();
        }
    }
}
class MyThread extends Thread {
    public void run() {
        for (int i = 0; i <20 ; i++) {
            SimpleDateFormat sdf = DateFormatUtil.synchronizedSimpleDateFormat() ;
            System.out.println(this.getName()+":"+i);
            if(sdf==null) {
                System.out.println("sdf==null");
            }
        }
    }
}
