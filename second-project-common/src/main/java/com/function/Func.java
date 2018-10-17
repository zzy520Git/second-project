package com.function;

/**
 * created by zhouzhongyi on 2018/7/22
 * Description:
 * 函数式接口
 * 注意：lambda表达式代码块中不允许调用接口的默认方法，而匿名内部类是可以的，这是一个区别
 * 但是lambda表达式对象是可以访问接口的默认方法的，只是抽象方法代码块中不允许
 *
 * lambda表达式代码块中的this指向创建表达式方法中的this
 */
@FunctionalInterface
public interface Func {
    String getValue() ;
    /**
     * 当函数式接口只有一条语句时，可以使用方法引用和构造器引用
     * 1. 类名::类方法   ==等价于==  (a,b,c)->类名.类方法(a,b,c)
     *          String::valueOf
     * 2. 类名::实例方法 ==等价于==  (a,b,c)->a.实例方法(b,c)
     *          String::substring
     * 3. 类名::new      ==等价于==  (a,b,c)->new 类名(a,b,c)
     *          String::new
     * 4. 特定对象::实例方法 ==等价于==  (a,b,c)->特定对象.实例方法(a,b,c)
     *          System.out::println
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
interface Supplier<T> {
    T get() ;
}
 */