package com.main;

import com.domain.bean.FieldIocBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * created by zhouzhongyi on 2018/7/21
 */
public class FieldIocMain {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/spring-domain-bean.xml") ;

        FieldIocBean fb = ctx.getBean("fieldIocBean", FieldIocBean.class) ;

        for (String s:fb.getBooks()) {
            System.out.println(s);
        }
    }
}
