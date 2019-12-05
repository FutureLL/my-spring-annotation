package com.atguigu.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @description:
 * @author: Mr.Li
 * @date: Created in 2019/12/5 8:41
 * @version: 1.0
 * @modified By:
 */

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    /**
     * @Transactional: 添加这个注解来告诉Spring这个方法是一个事务方法,这样Spring在执行这个方法的时候就会自动的进行事务控制,
     *                 如果整个方法正常执行,那么所有的操作都生效提交,如果出现异常,那么所有的方法都会滚
     */
    @Transactional
    public void insertUser(){
        userDao.insert();
        System.out.println("插入完成...");
        //因为没有加入任何的事务机制以及事务回滚机制,所以对数据库的插入还是会进行,但是控制台也会报错不会回滚
        int i = 10 / 0;
    }
}
