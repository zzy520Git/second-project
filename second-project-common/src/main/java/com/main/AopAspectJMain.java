package com.main;

import com.spring.serviceimpl.ModelServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * created by zhouzhongyi on 2018/7/21
 * Description:
 */
public class AopAspectJMain {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/spring-aop.xml") ;
        ModelServiceImpl ms = ctx.getBean("modelService", ModelServiceImpl.class) ;
        //ms.queryAddress();
        //ms.queryName() ;
        String age = ms.queryAge("zzy") ;
        System.out.println(age);
    }
}
