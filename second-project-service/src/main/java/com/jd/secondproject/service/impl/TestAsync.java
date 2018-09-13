package com.jd.secondproject.service.impl;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

/**
 * Description：
 *
 * @author zhouzhongyi1
 * DATE： 2018/9/13 12:02
 */
//下俩注解开启异步执行支持
@Configuration
@EnableAsync
@Component
public class TestAsync {
    /**
     * value=线程池名称
     * 此方法不能方法内调用，不能用private修饰，否则异步不生效
     */
    @Async("threadpool")
    public void testAsync() {
        System.out.println("TestAsync测试@Async注解");
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().toString());
    }
}
