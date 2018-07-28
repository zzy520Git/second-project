package com.domain.bean;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * created by zhouzhongyi on 2018/7/21
 */
@Component
public class InitDestroyBean {

    /**
     * 该注解等同于xml配置时中的init-method="init"
     */
    @PostConstruct
    public void init() {
        System.out.println("该方法会在依赖关系注入后进行回调");
    }

    /**
     * 该注解等同于xml配置时中的destroy-method="destroy"
     */
    @PreDestroy
    public void destroy() {
        System.out.println("该方法会在Bean销毁之前进行回调");
    }
}
