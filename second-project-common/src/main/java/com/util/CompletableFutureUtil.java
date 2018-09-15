package com.util;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Description：
 * CPU密集型适合用Stream，IO型适合用CompletableFuture
 * @author zhouzhongyi1
 * DATE： 2018/9/13 17:32
 */
public class CompletableFutureUtil {
    private static volatile boolean flag = true ;
    public static void testAllOf() {
        CompletableFuture cf1 = CompletableFuture.runAsync(()->{
            try {
                while(flag) {};
                Thread.sleep(1000);
                System.out.println("cf1 finished");
            } catch (Exception e) {}
        }) ;
        CompletableFuture cf2 = CompletableFuture.runAsync(()->{
            try {
                while(flag) {};
                Thread.sleep(2000);
                System.out.println("cf2 finished");
            } catch (Exception e) {}
        }) ;
        CompletableFuture cf3 = CompletableFuture.supplyAsync(()->{
            try {
                while(flag) {};
                Thread.sleep(3000);
                System.out.println("cf3 finished");
            } catch (Exception e) {}
            return "abc" ;
        }) ;
        System.out.println("start run task=" + System.currentTimeMillis());
        flag = false ;
        //会立即返回
        CompletableFuture result = CompletableFuture.allOf(cf1, cf2, cf3) ;
        System.out.println("get result=" + System.currentTimeMillis());
        try {
            //会阻塞，直至所有任务都完成才会返回
            Object obj = result.get() ;
            System.out.println("get obj=" + System.currentTimeMillis());
            System.out.println("obj=" + obj);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static void testThenRun() {
        CompletableFuture cf4 = CompletableFuture.runAsync(()->{
            try {
                while(flag) {};
                Thread.sleep(2000);
                System.out.println(Thread.currentThread() + "cf4 finished" + System.currentTimeMillis());
            } catch (Exception e) {}
        }) ;
        //等cf4执行完成后，会使用cf4的线程去执行该任务
        CompletableFuture result = cf4.thenRun(()->{
            try {
                while(flag) {};
                Thread.sleep(2000);
                System.out.println(Thread.currentThread() + "cf4 thenRun finished" + System.currentTimeMillis());
            } catch (Exception e) {}
            //会使用this这个线程再执行下个任务
        }).thenRun(()->{
            try {
                while(flag) {};
                Thread.sleep(2000);
                System.out.println(Thread.currentThread() + "thenRun.. finished" + System.currentTimeMillis());
            } catch (Exception e) {}
        }) ;
        flag = false ;
        System.out.println(Thread.currentThread() + "cf4 started" + System.currentTimeMillis());
        try {
            //Thread.sleep(5000);
            //会阻塞，直至任务都完成才会返回
            Object obj = result.get() ;
            System.out.println("get obj=" + System.currentTimeMillis());
            System.out.println("obj=" + obj);
        } catch (InterruptedException e) {

        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static void testThenRunAsync() {
        CompletableFuture cf5 = CompletableFuture.runAsync(()->{
            try {
                while(flag) {};
                Thread.sleep(3000);
                System.out.println(Thread.currentThread() + "cf5 finished" + System.currentTimeMillis());
            } catch (Exception e) {}
        }) ;
        //等cf5执行完成后，会使用其他的线程去执行该任务
        CompletableFuture result = cf5.thenRunAsync(()->{
            try {
                while(flag) {};
                Thread.sleep(2000);
                System.out.println(Thread.currentThread() + "cf5 thenRunAsync finished" + System.currentTimeMillis());
            } catch (Exception e) {}
            //会使用其他线程再执行下个任务
        }).thenRunAsync(()->{
            try {
                while(flag) {};
                Thread.sleep(1000);
                System.out.println(Thread.currentThread() + "thenRunAsync.. finished" + System.currentTimeMillis());
            } catch (Exception e) {}
        }) ;
        flag = false ;
        System.out.println(Thread.currentThread() + "cf5 started" + System.currentTimeMillis());
        try {
            //会阻塞，直至任务都完成才会返回
            Object obj = result.get() ;
            System.out.println("get obj=" + System.currentTimeMillis());
            System.out.println("obj=" + obj);
        } catch (InterruptedException e) {
        } catch (ExecutionException e) {
        }
    }
}
