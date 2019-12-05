package com.atguigu.test;

import com.atguigu.aop.MathCalculator;
import com.atguigu.bean.Boss;
import com.atguigu.bean.Car;
import com.atguigu.bean.Color;
import com.atguigu.config.MainConfigOfAOP;
import com.atguigu.config.MainConfigOfAutowired;
import com.atguigu.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Mr.Li
 * @version 1.0
 * @Description:
 * @Modified By:
 * @date 2019/12/1 6:32
 */
public class IOCTest_Aop {

    @Test
    public void test01(){
        //创建Ioc容器
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigOfAOP.class);

        //1、不要自己创建MathCalculator对象,要使用Spring容器中的组件
        MathCalculator math = context.getBean(MathCalculator.class);
        //将第二个参数值设置为0,用来演示异常
        //int value = math.div(1, 0);
        int value = math.div(1, 1);
        System.out.println(value);

        //关闭容器,对多实例不起作用
        context.close();
    }
}
