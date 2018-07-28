package com.main;

import com.domain.bean.LazyInitBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * created by zhouzhongyi on 2018/7/21
 */
public class LazyInitBeanMain {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/spring-domain-bean.xml") ;
        //去掉LazyInitBean的@Lazy注解时，此条输出顺序会改变
        System.out.println("此时lazyBean未初始化");
        LazyInitBean lb = ctx.getBean("lazyInitBean", LazyInitBean.class) ;

        lb.print();
    }
}
