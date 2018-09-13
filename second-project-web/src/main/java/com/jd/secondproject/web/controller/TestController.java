package com.jd.secondproject.web.controller;

import com.jd.secondproject.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @RequestMapping("requestAsync")
    public String requestAsync() {
        testService.testAsync();
        return "func/jsonForm" ;
    }


}
