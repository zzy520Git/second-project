package com.util.java;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Description：
 *
 * @author zhouzhongyi1
 * DATE： 2018/9/25 16:53
 */
public class MapUtil {
    public static void testCompute() {
        Map<String, Integer> countTicket = new HashMap<>() ;
        countTicket.put("小明", 1) ;
        countTicket.put("小王", 1) ;
        countTicket.put("小张", 1) ;
        BiFunction<String, Integer, Integer> bif = (s, i1)->{
            if(i1==null) {
                return 1 ;
            } else {
                return i1 + 1 ;
            }
        } ;
        countTicket.compute("小李", bif) ;
        countTicket.compute("小明", bif) ;
        countTicket.compute("小王", bif) ;
        countTicket.compute("小张", bif) ;
        countTicket.forEach( (k, v)->System.out.println(k+v) ) ;

        Function f = t-> 1 ;
    }
}
