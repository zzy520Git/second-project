package com.jd.secondproject.web.controller;

import com.jd.secondproject.manager.UserManager;
import com.jd.secondproject.service.UserService;
import com.jd.secondproject.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * created by zhouzhongyi
 * Date: 2018/1/19
 */
@Controller
@RequestMapping("/test")
public class TestController {
    @Autowired(required = false)
    private UserService userService ;

    @Autowired(required = false)
    private UserManager userManager ;

    @RequestMapping("/query.action")
    public ModelAndView query() {
        UserVo result = userService.queryById(1) ;
        //userManager.testTransaction();
        ModelAndView modelAndView = new ModelAndView("/index.jsp") ;
        System.out.println("啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊\n\n啊啊啊啊啊啊啊啊啊啊啊啊");
        return modelAndView;
    }
}
