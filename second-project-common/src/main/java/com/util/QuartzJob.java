package com.util;

/**
 * Description:
 * Quartz跑任务
 * @author zhouzhongyi
 * Date: 2018/8/26 19:18
 */
public class QuartzJob {
    //用于跑任务，方法名字随意，需要在配置文件中配置
    public void execute() {
        System.out.println("time ms:"+System.currentTimeMillis());
    }
}
