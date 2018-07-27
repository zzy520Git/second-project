package com.jd.secondproject.service.impl;

import com.jd.secondproject.dao.UserMapper;
import com.jd.secondproject.domain.User;
import com.jd.secondproject.service.UserService;
import com.jd.secondproject.vo.UserVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.io.UnsupportedEncodingException;

/**
 * created by zhouzhongyi on 2018/1/19
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper ;

    @Value("${workstation.jdbc.driver.master}")
    private String valueProperties ;

    @Override
    public UserVo queryById(long id) {
        UserVo userVo = new UserVo() ;
        User user = userMapper.selectByPrimaryKey(id);
        BeanUtils.copyProperties(user, userVo);
        return userVo ;
    }

    @Override
    public int insertNoTransaction() {
        User a = new User() ;
        a.setUsername("china###japan");
        a.setId(100L);
        String key = null ;
        try {
            key = DigestUtils.md5DigestAsHex("password".getBytes("UTF-8")) ;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        a.setPassword(key);
        userMapper.insertSelective(a) ;
        return 0 ;
    }

    @Override
    public String getValueProperties() {
        return valueProperties;
    }


}
