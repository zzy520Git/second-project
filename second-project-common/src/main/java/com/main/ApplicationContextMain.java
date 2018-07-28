package com.main;

import com.domain.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * created by zhouzhongyi on 2018/7/21
 */
public class ApplicationContextMain {
    public static void main(String[] args) {
        //当有多个配置文件时，可以传入多个参数xml配置文件路径(注意传入后缀名)，详见构造函数
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/spring-domain-bean.xml") ;

        Person person = ctx.getBean("person", Person.class) ;
        person.setName("小张");

        System.out.println(person.getName());
        /**
         "classpath:"和"classpath*:"的区别：
         classpath：只会到你的class路径中,当前jar,查找找文件。
         classpath*：不仅包含class路径，还包括jar文件中（class路径）进行查找。
         注意：用classpath*:需要遍历所有的classpath，所以加载速度是很慢的；因此，在规划的时候，
         应该尽可能规划好资源文件所在的路径，尽量避免使用classpath*。
         */

    }
}
