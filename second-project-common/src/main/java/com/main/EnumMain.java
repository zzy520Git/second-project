package com.main;

import com.enummodel.EnumModel;

/**
 * created by zhouzhongyi on 2018/7/22
 * Description:
 */
public class EnumMain {
    public static void main(String[] args) {
        for(EnumModel ins : EnumModel.values()) {
            System.out.println(ins.getDesc());
        }
    }
}
