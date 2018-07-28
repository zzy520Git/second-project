package com.domain.bean;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * created by zhouzhongyi on 2018/7/21
 */
@Component
/**
 * "@Lazy" 代表在spring容器初始化时，该bean不初始化，用到时再初始化。常用于开销大的类
 * 在xml文件中等同于配置lazy-init="true"
 * 注意的是：如果有其他非延迟加载类需要注入他，则该延迟Lazy失效
 */
@Lazy
public class LazyInitBean {
    public LazyInitBean() {
        System.out.println("容器初始化时，查看是否预初始化");
    }
    public void print() {
        System.out.println(this.getClass().getName());
    }
}
