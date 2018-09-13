package com.jd.secondproject.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.jd.secondproject.domain.User;
import com.main.GuidePrefVo;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.UUID;

/**
 * created by zhouzhongyi on 2018/7/24
 * Description:
 */
@Controller
@RequestMapping("/json")
public class JsonController {

    /**
     * 返回值是字符串类型时，只能是逻辑视图名
     * @return
     */
    @RequestMapping("/toJson")
    public String toJson() {
        return "func/jsonForm" ;
    }

    /**
     * 请求的是JSON对象，请求参数和pojo包装类中的属性名需一致，自动绑定
     * @param user 形参名随意，但建议是类名首字母小写
     */
    @RequestMapping("/requestJson2Pojo")
    @ResponseBody
    public User requestJson2Pojo(User user) {
        return user ;
    }

    /**
     * 请求的是JSON对象，需要请求参数和形参名一致才能绑定
     */
    @RequestMapping("/requestJson2Param")
    @ResponseBody
    public User requestJson2Param(Long id, String username) {
        User user = new User() ;
        user.setUsername(username);
        user.setId(id);
        return user ;
    }

    /**
     * 请求的是JSON字符串(注意：前端配置不同)，请求参数和pojo包装类中的属性名需一致，而且需要@RequestBody
     * 此类用法已很少使用
     */
    @RequestMapping("/requestJsonString2Pojo")
    @ResponseBody
    public User requestJsonString2Pojo(@RequestBody User user) {
        return user ;
    }

    /**
     * 请求的是表单,数据回显形参名尽量类名首字母小写,因为默认是调用addObject("小写key",obj)
     * 而且表单提交方法不能返回void
     */
    @RequestMapping(value = "/requestForm", method = RequestMethod.POST)
    public String requestForm(User user, MultipartFile img) {
        System.out.println(user.getId());
        System.out.println(user.getUsername()==null);

        //文件上传
        if(img != null) {
            String originalFilename = img.getOriginalFilename();
            if(StringUtils.hasLength(originalFilename)) {
                String suffix = originalFilename.substring(originalFilename.lastIndexOf(".")) ;
                File f = new File("D:\\"+UUID.randomUUID().toString()+suffix) ;
                try {
                    //img.transferTo(f);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else {
                System.out.println("文件上传有误");
            }
        }

        //转发时，请求参数和回显数据都不会丢失
        return "forward:toJson" ;
    }

    @RequestMapping("/abctest")
    @ResponseBody
    public GuidePrefVo test(Long id, String text) {
        System.out.println(id);
        List<GuidePrefVo> vos = JSONObject.parseArray(text, GuidePrefVo.class) ;
        System.out.println(vos);
        return new GuidePrefVo() ;
    }
}
