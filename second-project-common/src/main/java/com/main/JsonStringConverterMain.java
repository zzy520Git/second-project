package com.main;

import com.alibaba.fastjson.JSONObject;
import com.domain.JsonObjectTemplate;
import com.domain.Person;

import java.util.Date;

/**
 * Description:
 *
 * @author zhouzhongyi
 * Date: 2018/7/29 20:50
 */
public class JsonStringConverterMain {
    public static void main(String[] args) {
        JsonObjectTemplate jot = new JsonObjectTemplate("china", 0, 666) ;
        jot.getHashMap().put("japan", -1) ;
        jot.getHashMap().put("english", 888) ;
        jot.getPlist().add(new Person("zzy",99)) ;
        jot.getPlist().add(new Person("Bill",100)) ;
        jot.getProps().setProperty("address", "hello world") ;
        jot.setDate(new Date());
        String s = null ;
        try {
            //Java对象转json字符串的场景会很多，实践表明JSONObject可以满足要求
            s = JSONObject.toJSONString(jot) ;
            String s0 = "ABCDEFG" ;
            System.out.println(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //字符串转Java对象的场景较少，也能转换成功.即使不是正规json串，或者有单引号
        String jotString = "{\"date\":1532869187293,\"hashMap\":{\"japan\":-1,\"english\":888}"+
                ",\'it0\':0,\"it1\":666,\"plist\":[{\"age\":99,\"name\":\"zzy\",\"sex\":false},"+
                "{\"age\":100,\"name\":\"Bill\",\"sex\":false}],\"props\":{\"address\":\"hello world\"},\'value\':\"china\"}" ;
        try {
            JsonObjectTemplate jt = JSONObject.parseObject(jotString, JsonObjectTemplate.class) ;
            System.out.println(jt.getDate().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
