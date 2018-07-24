package com.jd.secondproject.service;

import com.jd.secondproject.vo.UserVo;

/**
 * created by zhouzhongyi on 2018/1/19
 */
public interface UserService {
    UserVo queryById(long id) ;

    int insertNoTransaction() ;
}
