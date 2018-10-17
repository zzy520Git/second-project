package com.main;

import java.util.Arrays;

/**
 * Description：
 *
 * @author zhouzhongyi1
 * DATE： 2018/8/14 11:14
 */
public class TestMain {
    private int x = 1 ;
    private Runnable r = ()->{
        int a = 1 ;
        this.x = 0 ;
    } ;

    public static void main(String[] args) throws Exception{

        String s = "/qqq,/123/a/dsf/" ;
        System.out.println(Arrays.toString(s.split("/",4)));


//        AtomicInteger atomicInteger = new AtomicInteger(0) ;
//        int expect = 0 ;
//        while((expect = atomicInteger.get()) < 5) {
//            if(atomicInteger.compareAndSet(expect, expect+1)) {
//                //TODO 开始执行任务
//                //atomicInteger.set(0);
//                break ;
//            }
//        }

//        Objects o ;
//        Math.random() ;
//        Collection c ;
//        SoftReference t ;
//        int[] arr = new int[10] ;
//        int[] at = arr.clone() ;
//        Object o =  null ;


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
        //System.out.println(HolidayUtil.solarToLunar("20220708"));
//        List<Integer> list = Arrays.asList(1,2,3,4,5) ;
//        list.stream().filter(t->t>3).forEach(System.out::println);
//        List<String> yl = new ArrayList<>(0) ;
        //LocalDateTimeUtil.testLocalDateTime();
        //MapUtil.testCompute();
//        List<String> l = new ArrayList<>() ;
//        l.add("1") ;
//        l.add(null) ;
//        l.add("abc") ;
////        l.forEach(s-> System.out.println(s==null ? 0 : s.length()));
//        EnumModel[] temp = EnumModel.values() ;
//        EnumModel t = EnumModel.valueOf("SPRING") ;
//        EnumModel t1 = EnumModel.valueOf(EnumModel.class, "SPRING") ;
//        System.out.println(t1.getDescription());
//        HashMap m = null ;
//        EnumMap<EnumModel, List<String>> em = new EnumMap<>(EnumModel.class) ;
//        em.put(EnumModel.AUTUMN, l) ;

    }
}
//class MyThreadAqs extends Thread{
//    private Lock lock ;
//    private int i ;
//    public MyThreadAqs(int i, Lock lock) {
//        this.lock = lock ;
//        this.i = i ;
//    }
//    @Override
//    public void run() {
//        try{
//            lock.lock();
//            System.out.println(this.getName() + ":" + i);
//            if(i==0) {
//                Thread.sleep(8000);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        finally {
//            lock.unlock();
//        }
//
//    }
//}
