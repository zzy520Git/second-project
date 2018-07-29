package com.jd.secondproject.web.controller;

import com.jd.secondproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * created by zhouzhongyi on 2018/7/24
 * Description:
 */
@Controller
@RequestMapping("/model")
public class ModelController {
    /**
     * springmvc其他常用注解
     * @RequestParam用于参数绑定、@ModelAttribute用于数据回显
     */

    @Autowired(required = false)
    private UserService userService ;

    @Value("${org.spring.version.key}")
    private String testValue ;

    /**
     * 当返回值是字符串型时，返回的是逻辑视图名
     * @return 逻辑视图页面名
     */
    @RequestMapping("/toIndex")
    public String toIndex(Model model, HttpServletRequest request) {
        System.out.println("testValue:" + testValue);
        model.addAttribute("key", "value") ;
        System.out.println("间接请求参数:" + request.getParameter("id"));
        userService.modelJD(null) ;
        return "index" ;
    }

    @RequestMapping("/toIndex1")
    public ModelAndView toIndex1(HttpServletRequest request, HttpServletResponse response,
        HttpSession session) {
        session.setAttribute("name", "zzy");
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("key", "value1") ;
        return modelAndView ;
    }

    /**
     * 返回void类型时，只能通过传统servlet方式操作视图，作用较小，已很少使用
     */
    @RequestMapping("/toIndex2")
    public void toIndex2(ModelMap modelMap, HttpServletResponse response) {
        modelMap.addAttribute("key", "value2") ;
        try {
            response.sendRedirect("toIndex");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 请求转发，转发到另一个Handler执行，请求参数不会丢失
     * @return 转发的url
     */
    @RequestMapping("/toIndex3")
    public String toIndex3(HttpServletRequest request) {
        System.out.println("直接请求参数:" + request.getParameter("id"));
        return "forward:toIndex" ;
    }

    /**
     * 请求重定向到另一个Handler执行，请求参数会丢失
     * @return 重定向的url
     */
    @RequestMapping("/toIndex4")
    public String toIndex4(HttpServletRequest request) {
        System.out.println("直接请求参数:" + request.getParameter("id"));
        return "redirect:toIndex" ;
    }
}
