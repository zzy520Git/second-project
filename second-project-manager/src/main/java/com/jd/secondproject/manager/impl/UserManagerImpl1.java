package com.jd.secondproject.manager.impl;

import com.jd.secondproject.manager.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * Description：
 *
 * @author zhouzhongyi1
 * @date 2018/7/27 18:44
 */
@Service
public class UserManagerImpl1 implements UserManager{
    @Autowired
    private TransactionTemplate transactionTemplate ;

    @Override
    public String testTransaction() {
        return this.transactionTemplate.execute(transactionStatus -> {
            try {

            } catch(Exception e) {
                transactionStatus.setRollbackOnly();
                System.out.println("事务回滚啦：" + e.getMessage()) ;
            }
            return "fail" ;
        });
    }
}
