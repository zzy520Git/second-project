package com.spring.serviceimpl;

import org.springframework.stereotype.Service;

/**
 * created by zhouzhongyi on 2018/7/21
 * Description:
 */
@Service("modelService")
public class ModelServiceImpl {
    public void queryAddress() {
        System.out.println("查询地址业务逻辑");
    }

    public String queryName() {
        System.out.println("查询姓名业务逻辑");
        return "zzy" ;
    }

    public String queryAge(String name) {
        System.out.println(this + "  根据姓名查询年龄业务逻辑：" + name.toString());
        return "本应该是24岁" ;
    }
}
