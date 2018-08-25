package com.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Semaphore;

/**
 * Description:
 * 启动rpc服务,启动入口
 * @author zhouzhongyi
 * Date: 2018/8/25 13:41
 */
public class SpringLoaderMain {
    private static final Logger logger = LoggerFactory.getLogger(SpringLoaderMain.class) ;
    private static volatile boolean running = true ;
    private static final Semaphore semaphore = new Semaphore(1) ;

    public static void main(String[] args) {
        try {
            semaphore.acquire();
            try {
                final ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-test.xml") ;
                Runtime.getRuntime().addShutdownHook(new Thread(()->{
                    try {
                        context.stop();
                        System.out.println("SpringLoaderMain.class中的spring服务stopped!");
                        //logger.info("SpringLoaderMain.class中的spring服务stopped!");
                    } catch (Throwable t) {
                        System.out.println(t.toString());
                        //logger.error(t.getMessage(), t);
                    }
                    synchronized (SpringLoaderMain.class) {
                        running = false ;
                        SpringLoaderMain.class.notify();
                    }
                })) ;
                context.start();
                //logger.info("SpringLoaderMain.class中的spring服务started!");
                System.out.println(new SimpleDateFormat("[yyyy-MM-dd HH:mm:ss]").format(new Date()) + " SpringLoaderMain.class中的spring服务started!");
            } catch (Exception e) {
                e.printStackTrace();
                //logger.error(e.getMessage(), e);
                semaphore.release();
                System.exit(1);
            }
            synchronized (SpringLoaderMain.class) {
                while(running) {
                    try{
                        SpringLoaderMain.class.wait();
                    } catch (Throwable e) {
                    }
                }
            }
        } catch (Throwable e) {
        } finally {
            System.out.println("释放锁许可");
            semaphore.release();
        }
    }
}
