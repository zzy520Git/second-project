package com.springmvc;

import com.domain.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * created by zhouzhongyi on 2018/7/23
 * Description:
 */
@Controller
@RequestMapping("/model")
public class ModelController {
    /**
     * springmvc支持的参数绑定有如下几种：(一般用于对应html标签中的name属性)
     * 1.形参中的request,response,session,Model,ModelMap
     * 2.简单数据类型及其数组类型，整型，字符串，日期类型(条件是请求参数名和形参名保持一致)
     *      当请求参数名和形参名不一致时，用@RequestParam注解进行绑定
     * 3.pojo的包装类型(条件是请求参数名要和pojo的属性名对应)
     * 4.可以自定义参数绑定，需要实现Converter
     * 5.List类型和Map尽量用包装类型进行绑定
     */

    @RequestMapping("/paramBind")
    public void paramBind(@RequestParam(value = "username", defaultValue = "") String name, @ModelAttribute("p") Person person) {

    }

    /**
     * springmvc常用的数据回显方式：(一般用于对应html标签中的value属性)
     * 1.对于包装类型，如果形参是类名首字母小写，那么自动回显到类名首字母小写的变量中，如上person.age
     *          如果不是类名首字母小写，那么可以使用注解@ModelAttribute，如上即是p.age
     * 2.简单类型数据回显只能用Model等加入
     */
}
