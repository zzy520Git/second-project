package com.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * 定义一个切面bean，也就是切面类，类中方法即为增强处理.
 * "@Aspect"需要进行包扫描，这样才会被看做增强Bean
 */
@Aspect
public class AspectBean {
    /**
     * spring AOP切入点表达式的几种方式
     * 1. "execution(* com.spring.serviceimpl.*.*(..))"
     */

    /**
     * 定义切入点，切入点标识符即为方法名
     * 方法返回值必须是void，而且方法体通常为空
     * 权限任意，如果为public则，其他类也可以用该切入点,但需要加类名，如AspectBean.myPointcut()
     */
    @Pointcut("execution(* com.spring.serviceimpl.*.*(..))")
    private void myPointcut() {}

    /**
     * before增强处理
     * 当执行切入点方法之前，执行此方法(被织入)
     */
    @Before("execution(* com.spring.serviceimpl.*.*(..))")
    public void beforeAdvice() {
        System.out.println("before增强处理");
    }

    /**
     * around增强处理，功能最强大，优先级最高，可以阻止方法执行，改变返回值，改变实参等一系列操作
     * @param pjp around增强处理的第一个形参必须是ProceedingJoinPoint类型
     * @return 返回实际目标方法返回值
     * 注意：around增强处理通常需要在线程安全的条件下执行，即不能用成员变量共享数据
     */
    @Around("execution(* com.spring.serviceimpl.ModelServiceImpl.queryAge(..))")
    public Object aroundAdvice(ProceedingJoinPoint pjp) {
        /**
         * 通过pjp可以得到目标方法的传入参数和目标对象
         */
        Object[] args = pjp.getArgs() ;
        Object target = pjp.getTarget() ;
        System.out.println(args.length + "  "+ args[0]);
        System.out.println(target + "\n" + pjp.getThis());

        System.out.println("开始执行目标方法");
        try {
            pjp.proceed( /*这里可以传新参数改变实参，否则为原实参传入*/ ) ;
        } catch (Throwable e) {
            System.out.println("不好意思，around增强处理报错了");
            e.printStackTrace();
        }
        return "实际是18岁" ;
    }

    /**
     * after增强处理，与afterReturning的区别是，无论目标方法执行成功与否都会被织入，常用于释放资源
     */
    @After(value = "myPointcut()")
    public void afterAdvice() {
        System.out.println("after增强处理");
    }

    /**
     * afterReturning增强处理，在切入点方法执行成功之后才织入
     * @param ret 可有可无，如果有可以获取增强方法的返回值。注意标识必须和形参一样
     */
    @AfterReturning(pointcut = "execution(* com.spring.serviceimpl.ModelServiceImpl.queryName(..))", returning = "ret")
    public void afterReturningAdvice(Object ret) {
        System.out.println("afterReturning增强处理。我们来看看返回值ret是什么：" + ret);
    }
}
