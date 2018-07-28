package com.domain.bean;

import com.domain.Person;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * created by zhouzhongyi on 2018/7/21
 */
@Setter
@Getter
/**
 * 集合类型的依赖注入见spring-domian-bean.xml配置文件的配置，例子见FieldIocMain
 */
public class FieldIocBean {

    List<String> schools ;

    Map<String, String> scores ;

    Map<String, Person> persons ;

    Properties props ;

    Set<String> citys ;

    String[] books ;
}
