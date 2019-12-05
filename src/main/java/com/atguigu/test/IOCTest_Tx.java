package com.atguigu.test;

import com.atguigu.tx.TxConfig;
import com.atguigu.tx.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Mr.Li
 * @version 1.0
 * @Description:
 * @Modified By:
 * @date 2019/12/1 6:32
 */
public class IOCTest_Tx {

    @Test
    public void test01(){
        //创建Ioc容器
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TxConfig.class);

        UserService userService = context.getBean(UserService.class);
        userService.insertUser();

        //关闭容器,对多实例不起作用
        context.close();
    }
}
