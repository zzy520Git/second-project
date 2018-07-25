package com.jd.secondproject.web.controller;

import com.jd.secondproject.vo.UserVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * created by zhouzhongyi on 2018/7/24
 * Description:
 */
@Controller
@RequestMapping("/json")
public class JsonController {
    /**
     * 请求的是JSON串，自动转为java对象需要使用@RequestBody注解，另外请求参数和pojo包装类中的属性名需一致
     * @param vo 形参名随意，但建议是类名首字母小写
     */
    @RequestMapping("/requestJson2Pojo")
    public void requestJson2Pojo(@RequestBody UserVo vo) {

    }

    /**
     * 请求的是JSON串，需要请求参数和形参名一致才能绑定
     */
    @RequestMapping("/requestJson2Param")
    public void requestJson2Param(Integer id, String username) {

    }

    /**
     * 请求的是表单
     */
    @RequestMapping(value = "/requestForm", method = RequestMethod.POST)
    public void requestForm(Integer id, String username) {

    }
}
