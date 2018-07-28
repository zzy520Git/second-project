package com.function;

/**
 * created by zhouzhongyi on 2018/7/22
 * Description:
 * 函数式接口
 * 注意：lambda表达式中不允许调用接口的默认方法，而匿名内部类是可以的，这是一个区别
 */
@FunctionalInterface
public interface Func {
    String getValue() ;
    /**
     * 当函数式接口只有一条语句时，可以使用方法引用和构造器引用
     * 1. 类名::类方法   ==等价于==  (a,b,c)->类名.类方法(a,b,c)
     * 2. 类名::实例方法 ==等价于==  (a,b,c)->a.实例方法(b,c)
     * 3. 类名::new      ==等价于==  (a,b,c)->new 类名(a,b,c)
     */
}
/**
 * 常见的3种函数式接口
interface Function<T, R> {
    R apply(T t) ;
}
interface Consumer<T> {
    void accept(T t) ;
}
interface Predicate<T> {
    boolean test(T t) ;
}
 */