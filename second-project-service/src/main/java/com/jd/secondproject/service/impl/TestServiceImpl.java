package com.jd.secondproject.service.impl;

import com.jd.secondproject.dao.UpdatelistMapper;
import com.jd.secondproject.domain.Updatelist;
import com.jd.secondproject.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Description：
 *
 * @author zhouzhongyi1
 * DATE： 2018/9/13 11:08
 */
@Service("testService")
public class TestServiceImpl implements TestService {
    @Autowired
    private TestAsync testAsync ;

    @Autowired
    private UpdatelistMapper updatelistMapper ;

    @Override
    public void testAsync() {
//        System.out.println("TestServiceImpl测试@Async注解");
//        System.out.println(Thread.currentThread().getName());
//        System.out.println(Thread.currentThread().toString());
//        testAsync.testAsync();
        List<String> list = new ArrayList<>(1) ;
        list.add("bb") ;
        List<Updatelist> temp = updatelistMapper.queryTest(list,false) ;
        System.out.println(temp);
    }
}
