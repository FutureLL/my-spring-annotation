package com.atguigu.test;

import com.atguigu.bean.Boss;
import com.atguigu.bean.Car;
import com.atguigu.bean.Color;
import com.atguigu.bean.Person;
import com.atguigu.config.MainConfigOfAutowired;
import com.atguigu.config.MainConfigOfPropertyValues;
import com.atguigu.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @author Mr.Li
 * @version 1.0
 * @Description:
 * @Modified By:
 * @date 2019/12/1 6:32
 */
public class IOCTest_Autowired {

    @Test
    public void test01(){
        //创建Ioc容器
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigOfAutowired.class);

        BookService bookService = context.getBean(BookService.class);
        System.out.println(bookService.toString());
        bookService.print();

        System.out.println("==================");

        Boss boss = context.getBean(Boss.class);
        System.out.println(boss);
        Car car = context.getBean(Car.class);
        System.out.println(car);
        Color color = context.getBean(Color.class);
        System.out.println(color);

        //关闭容器,对多实例不起作用
        context.close();
    }
}
