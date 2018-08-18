package com.main;

/**
 * Description：
 *
 * @author zhouzhongyi1
 * DATE： 2018/8/14 11:14
 */
public class TestMain {
    public static void main(String[] args) {
        String ext = "a.xls".substring("a.xls".lastIndexOf(".")+1) ;
        System.out.println(ext);
    }
}
