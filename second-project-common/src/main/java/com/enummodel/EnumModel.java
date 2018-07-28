package com.enummodel;

import lombok.Getter;

/**
 * created by zhouzhongyi on 2018/7/22
 * Description:
 * 枚举模板类：以季节为例
 *
 * 注意：
 * 1.非抽象的枚举类默认是final修饰，不能继承。
 * 2.枚举类的实例必须在第一行全部列出
 * 3.枚举类如果提供构造方法，则必须用private修饰，默认缺省也是private修饰的
 * 4.枚举类可以实现接口，但是每个实例都必须实现
 */
public enum EnumModel implements EnumInterface{
    SPRING(0, "春季"), SUMMER(1, "夏季"), AUTUMN(2, "秋季"), WINTER(3, "冬季");

    @Getter
    private final int code ;
    @Getter
    private final String desc ;

    //构造函数可有可无，具体看需求，见注意点3
    private EnumModel(int code, String desc) {
        this.code = code ;
        this.desc = desc ;
    }

    /**
     * 可以4个实例统一实现该接口，也可有分别不同的实现
     * @return
     */
    @Override
    public String getDescription() {
        return "返回季节的描述" ;
    }
}
