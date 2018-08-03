package com.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Description：
 *
 * @author zhouzhongyi1
 * @date 2018/8/3 14:10
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface JMonitor {
    String jKey();

    String jAppName() default "";

    //..etc
}
