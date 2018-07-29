package com.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * created by zhouzhongyi on 2018/7/21
 */
@Setter
@Getter
public class Person {
    private String name ;

    private int age ;

    private String address ;

    /**
     * true为男性，否则为女性
     */
    private boolean sex ;
    public Person() {}
    public Person(String n, int val) {
        this.name = n ;
        this.age = val ;
    }
    public Person(String n) {
        this.name = n ;
    }
}
