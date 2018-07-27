package com.jd.secondproject.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * created by zhouzhongyi on 2018/1/19
 * @author zhouzhongyi
 */
public class BaseManager {
    @Autowired
    private DataSourceTransactionManager transactionManager;

    //这样写不好，每次new一个(有待商榷)
    protected TransactionTemplate getTransactionTemplate(){
        return new TransactionTemplate(transactionManager);
    }

}
