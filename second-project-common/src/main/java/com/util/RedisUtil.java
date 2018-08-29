package com.util;

import com.jd.jim.cli.Cluster;
import lombok.Setter;

import java.util.concurrent.TimeUnit;

/**
 * Description：
 * Redis工具类
 * @author zhouzhongyi1
 * DATE： 2018/8/28 19:43
 */
public class RedisUtil {

    @Setter
    private Cluster cluster ;

    //原子操作
    public boolean setNX(String key, String value) {
        return cluster.setNX(key, value) ;
    }
    //原子操作
    public void setEx(String key, String value, long timeout, TimeUnit unit) {
        cluster.setEx(key, value, timeout, unit) ;
    }
    public void set(String key, String value) {
        cluster.set(key, value) ;
    }
    //原子操作
    public Long incr(String key) {
        return cluster.incr(key) ;
    }
    public String get(String key) {
        return cluster.get(key) ;
    }
    public Long del(String key) {
        return cluster.del(key) ;
    }
    public boolean expire(String key, long timeout, TimeUnit unit) {
        return cluster.expire(key, timeout, unit) ;
    }


}
