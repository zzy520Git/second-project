package com.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

/**
 * Description:
 *
 * @author zhouzhongyi
 * Date: 2018/7/29 20:41
 */
@Setter
@Getter
public class JsonObjectTemplate {
    private HashMap<String, Integer> hashMap = new HashMap<>() ;
    private String value ;
    private int it0 ;
    private Integer it1 ;
    private List<Person> plist = new ArrayList<>() ;
    private Properties props = new Properties() ;
    private Date date ;
    public JsonObjectTemplate() {}
    public JsonObjectTemplate(String val, int x, Integer y) {
        this.value = val ;
        this.it0 = x ;
        this.it1 = y ;
    }
}
