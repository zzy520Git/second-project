package com.jd.secondproject.web.controller;

import com.jd.secondproject.manager.UserManager;
import com.jd.secondproject.service.UserService;
import com.jd.secondproject.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * Description：
 *
 * @author zhouzhongyi1
 * @date 2018/7/26 18:12
 */
@Controller
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired(required = false)
    private UserService userService ;

    @Resource
    private UserManager userManager ;

    @RequestMapping("/queryByService")
    public ModelAndView queryByService() {
        UserVo result = userService.queryById(1) ;
        userService.insertNoTransaction() ;
        ModelAndView modelAndView = new ModelAndView("index") ;
        modelAndView.addObject("result", result) ;
        System.out.println("啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊\n\n啊啊啊啊啊啊啊啊啊啊啊啊");
        return modelAndView;
    }

    @RequestMapping("/queryByManager")
    public ModelAndView queryByManager() {
        UserVo result = userService.queryById(1) ;
        //userManager.testTransaction();
        userManager.testAnnotation() ;
        System.out.println(result.getUsername());
        ModelAndView modelAndView = new ModelAndView("index") ;
        System.out.println("啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊\n\n啊啊啊啊啊啊啊啊啊啊啊啊");
        return modelAndView;
    }

    @RequestMapping("/queryValue")
    public ModelAndView queryValue() {
        ModelAndView modelAndView = new ModelAndView("index") ;
        System.out.println("啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊\n\n啊啊啊啊啊啊啊啊啊啊啊啊");
        System.out.println("能够读取spring配置文件的值:" + userService.getValueProperties());
        return modelAndView;
    }
}
