package com.jd.secondproject.manager.impl;

import com.jd.secondproject.dao.UserMapper;
import com.jd.secondproject.domain.User;
import com.jd.secondproject.manager.BaseManager;
import com.jd.secondproject.manager.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * created by zhouzhongyi on 2018/1/19
 */
@Service("userManager")
public class UserManagerImpl extends BaseManager implements UserManager{
    @Autowired
    private UserMapper userMapper ;

    @Override
    public String testTransaction() {
        //建议使用lambda表达式，而不是匿名内部类
        return this.getTransactionTemplate().execute(transactionStatus -> {
            try {
                    User user = new User() ;
                    user.setId(2L);
                    user.setUsername("蛋哥");

                    userMapper.insert(user) ;
                    userMapper.insert(user) ;

                    return "success" ;
                }
                catch(Exception e) {
                    transactionStatus.setRollbackOnly();
                    System.out.println("事务回滚啦：" + e.getMessage()) ;
                }
                return "fail";
        }) ;
    }
}
