package com.jd.secondproject.web.controller;

import com.jd.secondproject.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * Description：
 *
 * @author zhouzhongyi1
 * DATE： 2018/9/13 11:12
 */
@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService ;

    @Resource
    private List<String> listbeanID ;

    @RequestMapping("requestAsync")
    public String requestAsync() {
        List l = listbeanID ;
        //testService.testAsync();
        return "func/jsonForm" ;
    }


}
