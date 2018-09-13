package com.jd.secondproject.service.impl;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * Description：
 *
 * @author zhouzhongyi1
 * DATE： 2018/9/13 12:14
 */
public class MyThreadFactory implements ThreadFactory {
    private static final ThreadFactory tf = Executors.defaultThreadFactory() ;
    @Override
    public Thread newThread(Runnable r) {
        Thread result = tf.newThread(r) ;
        result.setName("zzy自定义线程：" + result.getName());
        return result ;
    }
}
