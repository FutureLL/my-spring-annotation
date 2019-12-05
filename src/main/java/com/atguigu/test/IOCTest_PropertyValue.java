package com.atguigu.test;

import com.atguigu.bean.Person;
import com.atguigu.config.MainConfigOfLifeCycle;
import com.atguigu.config.MainConfigOfPropertyValues;
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
public class IOCTest_PropertyValue {

    @Test
    public void test01(){
        //1、创建Ioc容器
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigOfPropertyValues.class);
        System.out.println("容器创建完成");

        //输出所有的bean
        printBeans(context);
        System.out.println("==================");
        Person person = (Person) context.getBean("person");
        System.out.println(person);
        System.out.println("==================");
        ConfigurableEnvironment environment = context.getEnvironment();
        String property = environment.getProperty("person.nickName");
        System.out.println(property);

        //关闭容器,对多实例不起作用
        context.close();
    }

    public void printBeans(AnnotationConfigApplicationContext context){
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String name : beanDefinitionNames){
            System.out.println(name);
        }
    }
}
