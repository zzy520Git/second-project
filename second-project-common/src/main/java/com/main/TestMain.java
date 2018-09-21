package com.main;

import com.util.HolidayUtil;

import java.util.concurrent.locks.Lock;

/**
 * Description：
 *
 * @author zhouzhongyi1
 * DATE： 2018/8/14 11:14
 */
public class TestMain {
    public static void main(String[] args) throws Exception{
//        String ext = "a.xls".substring("a.xls".lastIndexOf(".")+1) ;
//        System.out.println(ext);
//        Date d = new Date() ;
//        System.out.println(d.toString());
//        String s = "[{'id':1,'useId':1},{'id':2,'useId':2},{'id':3,'orderId':33,'useId':3}]" ;
//        List<GuidePrefVo> vos = JSONObject.parseArray(s, GuidePrefVo.class) ;
//        System.out.println(vos);
//        ThreadPoolExecutor executor = null ;
//        ThreadPoolTaskExecutor tk = null ;
//        ForkJoinPool pool = ForkJoinPool.commonPool() ;

        //CompletableFutureUtil.testAllOf();
        //CompletableFutureUtil.testThenRun();
        //CompletableFutureUtil.testThenRunAsync();
//        List list = new ArrayList<>() ;
//        ReentrantLock lock = new ReentrantLock() ;
//        LinkedBlockingQueue q = new LinkedBlockingQueue(1) ;
//        LockSupport s ;
//        Lock lock = new ReentrantLock() ;
//        new MyThreadAqs(0, lock).start();
//        Thread.sleep(500);
//        for(int i=1 ; i<10 ; i++) {
//            new MyThreadAqs(i, lock).start();
//            try {
//                if(i<5) {
//                    Thread.sleep(500);
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
        System.out.println(HolidayUtil.solarToLunar("20220708"));

    }
}
class MyThreadAqs extends Thread{
    private Lock lock ;
    private int i ;
    public MyThreadAqs(int i, Lock lock) {
        this.lock = lock ;
        this.i = i ;
    }
    @Override
    public void run() {
        try{
            lock.lock();
            System.out.println(this.getName() + ":" + i);
            if(i==0) {
                Thread.sleep(8000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }

    }
}
