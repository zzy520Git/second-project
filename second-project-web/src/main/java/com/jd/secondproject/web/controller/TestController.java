package com.jd.secondproject.web.controller;

import com.jd.secondproject.manager.UserManager;
import com.jd.secondproject.service.UserService;
import com.jd.secondproject.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;

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
        //userService.insertNoTransaction() ;
        //userManager.testTransaction();
        ModelAndView modelAndView = new ModelAndView("/index.jsp") ;
        System.out.println("啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊\n\n啊啊啊啊啊啊啊啊啊啊啊啊");
        return modelAndView;
    }

    /**
     * 需要用到common-io包和common-fileupload包
     * @param file
     */
    @RequestMapping("/upload")
    public void upload(MultipartFile file) {
        if(file != null) {
            String fileName = file.getOriginalFilename() ;
            File newFile = new File("abc.txt") ;
            try {
                file.transferTo(newFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
