package com.jd.secondproject.service.impl;

import com.common.ResponseResult;
import com.jd.secondproject.dao.UserMapper;
import com.jd.secondproject.domain.User;
import com.jd.secondproject.service.UserService;
import com.jd.secondproject.vo.UserVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

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

    @Override
    public ResponseResult modelJD(Integer parameter) {
        logger.info("###zzy###zzy###zzy###zzy\n\n" +
                "###zzy###zzy###zzy###zzy\n\n" +
                "###zzy###zzy###zzy###zzy\n\n");
        //1.校验参数合法性
        if(parameter == null) {
            return ResponseResult.paramEmpty() ;
        }

        //2.开始监控
        System.out.println("registerInfo");
        try {
            if(parameter<0) {
                //3.业务逻辑
                return ResponseResult.paramError() ;
            }
            if(parameter==0) {
                //3.业务逻辑
                return ResponseResult.success() ;
            }
            else {
                //3.业务逻辑
                return ResponseResult.newInstance().setCode(ResponseResult.FAILURE).setDesc(ResponseResult.NO_OPERATE_AUTH) ;
            }
        } catch (Exception e) {
            //4.打日志
            logger.error("系统异常");
            //监控报警
            System.out.println("functionError");
        } finally {
            //结束监控
            System.out.println("registerInfoEnd");
        }
        return ResponseResult.failure() ;
    }
}
