package com.atguigu.test;

import com.atguigu.bean.Yellow;
import com.atguigu.config.MainConfigOfProfile;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

/**
 * @author Mr.Li
 * @version 1.0
 * @Description:
 * @Modified By:
 * @date 2019/12/1 6:32
 */
public class IOCTest_Profile {

    @Test
    public void test01() {
        //创建Ioc容器
        //AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigOfProfile.class);
        //1、创建一个AnnotationConfigApplicationContext对象
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        //2、设置需要激活的环境
        context.getEnvironment().setActiveProfiles("test", "Dev");
        //3、注册主配置类
        context.register(MainConfigOfProfile.class);
        //4、启动刷新容器
        context.refresh();

        Yellow yellow = context.getBean(Yellow.class);
        System.out.println(yellow);

        String[] beanNamesForType = context.getBeanNamesForType(DataSource.class);
        for (String name : beanNamesForType) {
            System.out.println(name);
        }

        //关闭容器,对多实例不起作用
        context.close();
    }
}
