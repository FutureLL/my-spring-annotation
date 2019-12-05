package com.atguigu.test;

import com.atguigu.config.MainConfigOfLifeCycle;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Mr.Li
 * @version 1.0
 * @Description:
 * @Modified By:
 * @date 2019/12/1 6:32
 */
public class IOCTest_LeftCycle {

    @Test
    public void test01(){
        //1、创建Ioc容器
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
        System.out.println("容器创建完成");

        //多实例bean在获取的时候才创建对象
        Object car = context.getBean("cat");

        //关闭容器,对多实例不起作用
        context.close();
    }
}
