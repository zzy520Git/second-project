package com.main;

import com.util.CompletableFutureUtil;

/**
 * Description：
 *
 * @author zhouzhongyi1
 * DATE： 2018/8/14 11:14
 */
public class TestMain {
    public static void main(String[] args) {
//        String ext = "a.xls".substring("a.xls".lastIndexOf(".")+1) ;
//        System.out.println(ext);
//        Date d = new Date() ;
//        System.out.println(d.toString());
//        String s = "[{'id':1,'useId':1},{'id':2,'useId':2},{'id':3,'orderId':33,'useId':3}]" ;
//        List<GuidePrefVo> vos = JSONObject.parseArray(s, GuidePrefVo.class) ;
//        System.out.println(vos);
//        ThreadPoolExecutor executor = null ;
//        ThreadPoolTaskExecutor tk = null ;
//        ForkJoinPool pool = ForkJoinPool.commonPool() ;

        //CompletableFutureUtil.testAllOf();
        //CompletableFutureUtil.testThenRun();
        CompletableFutureUtil.testThenRunAsync();
    }
}
