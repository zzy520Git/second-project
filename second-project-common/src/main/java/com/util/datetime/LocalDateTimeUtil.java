package com.util.datetime;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * Description：
 *
 * @author zhouzhongyi1
 * DATE： 2018/9/24 11:44
 */
public class LocalDateTimeUtil {
    public static void testLocalDateTime() {
        LocalDateTime localDateTime = LocalDateTime.now() ;
        String ld1 = localDateTime.toString() ;
        String ld2 = localDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME) ;
        String ld3 = localDateTime.format(DateTimeFormatter.ofPattern("dd HH:ss")) ;
        String ld4 = localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) ;
        System.out.println(ld1);
        System.out.println(ld2);
        System.out.println(ld3);
        System.out.println(ld4);
        System.out.println(LocalDateTime.parse("1993-05-20T06:06:06").toString());

        Date d = Date.from(Clock.systemDefaultZone().instant()) ;
        System.out.println(d);

        try {
            LocalDateTime x1 = LocalDateTime.now() ;
            Thread.sleep(1999);
            LocalDateTime x2 = LocalDateTime.now() ;
            System.out.println(ChronoUnit.SECONDS.between(x1, x2));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
