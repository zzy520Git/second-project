package com.jd.secondproject.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * created by zhouzhongyi on 2018/7/24
 * Description:
 */
@Controller
@RequestMapping("/model")
public class ModelController {
    @RequestMapping("/toIndex")
    public String toIndex() {
        return "index" ;
    }
}
