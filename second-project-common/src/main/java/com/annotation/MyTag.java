package com.annotation;

import java.lang.annotation.*;

/**
 * created by zhouzhongyi on 2018/7/22
 * Description:
 * 自定义注解
 * RetentionPolicy.RUNTIME代表运行时可以提取注解；RetentionPolicy.CLASS在运行时不能读取(默认值)；RetentionPolicy.SOURCE注解只保留在源代码中
 * ElementType.TYPE, ElementType.FIELD, ElementType.METHOD分别代表注解可以修饰类，属性，方法
 * "@Inherited"代表如果某个类被该注解修饰，那么该类的子类也被该注解修饰
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
@Inherited
public @interface MyTag {
    int value() default 0 ;
    String desc() default "注解描述" ;
}
