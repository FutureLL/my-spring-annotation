package com.atguigu.test;

import com.atguigu.bean.Boss;
import com.atguigu.bean.Car;
import com.atguigu.bean.Color;
import com.atguigu.config.MainConfigOfAutowired;
import com.atguigu.dao.BookDao;
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
public class IOCTest_Autowired {

    @Test
    public void test01() {
        //创建Ioc容器
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigOfAutowired.class);

        BookService bookService = context.getBean(BookService.class);
        System.out.println(bookService);
        // bookService.print();

        // BookDao bookDao2 = (BookDao) context.getBean("bookDao2");
        // System.out.println(bookDao2);

        BookDao bookDao = context.getBean(BookDao.class);
        System.out.println(bookDao);


        System.out.println("==================");

        Boss boss = context.getBean(Boss.class);
        System.out.println(boss);
        // Boss [car = com.atguigu.bean.Car@7bd4937b]
        Car car = context.getBean(Car.class);
        System.out.println(car);
        // com.atguigu.bean.Car@7bd4937b
        Color color = context.getBean(Color.class);
        System.out.println(color);
        // Color [car=com.atguigu.bean.Car@7bd4937b]

        //关闭容器,对多实例不起作用
        context.close();
    }
}
