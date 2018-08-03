package com.jd.secondproject.manager.impl;

import com.annotation.JMonitor;
import com.exception.BusinessException;
import com.jd.secondproject.dao.UserMapper;
import com.jd.secondproject.domain.User;
import com.jd.secondproject.manager.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * Description：
 *
 * @author zhouzhongyi1
 * @date 2018/7/27 18:44
 */
@Service("userManager")
public class UserManagerImpl implements UserManager{
    @Autowired
    private TransactionTemplate transactionTemplate ;

    @Autowired
    private UserMapper userMapper ;

    @Override
    public String testTransaction() {
        //建议使用lambda表达式，而不是匿名内部类
        return this.transactionTemplate.execute(transactionStatus -> {
            try {
                User user = new User() ;
                user.setId(100L);
                user.setUsername("china###japan");
                userMapper.insert(user) ;
                userMapper.insert(user) ;
                return "success" ;
            } catch(Exception e) {
                transactionStatus.setRollbackOnly();
                System.out.println("事务回滚啦：" + e.getMessage()) ;
            }
            return "fail" ;
        });
    }

    /**
     * 注意aop织入的顺序
     * @return
     */
    @Override
    @JMonitor(jKey = "com.jd.secondproject.manager.impl.UserManagerImpl.testAnnotation", jAppName = "second-project")
    @Transactional(rollbackFor = Exception.class, readOnly = false)
    public String testAnnotation() {
        //业务逻辑校验
        if(System.currentTimeMillis() < 1000) {
            return "fail" ;
        }
        try {
            User user = new User() ;
            user.setId(100L);
            user.setUsername("china###japan");
            userMapper.insert(user) ;
            userMapper.insert(user) ;
            //业务逻辑1
            //可以打印日志
            //业务逻辑2
        } catch (Exception e) {
            //可以打印日志
            //处理注解事务和注解监控时，必须手动抛出异常
            throw BusinessException.asBusinessException() ;
        }
        return "fail" ;
    }
}
