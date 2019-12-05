package com.atguigu.test;

import com.atguigu.bean.Blue;
import com.atguigu.bean.Person;
import com.atguigu.config.MainConfig;
import com.atguigu.config.MyConfig2;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

import java.util.Map;

/**
 * @author Mr.Li
 * @version 1.0
 * @Description:
 * @Modified By:
 * @date 2019/11/30 17:34
 */
public class IOCTest {

    @Test
    public void test01(){
        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String name : beanDefinitionNames){
            System.out.println(name);
        }
    }

    @Test
    public void test02(){
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig2.class);
        System.out.println("Ioc容器创建完成...");

        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String name : beanDefinitionNames){
            System.out.println(name);
        }

        Person person1 = (Person) context.getBean("person2");
        Person person2 = (Person) context.getBean("person2");
        System.out.println(person1);
        //单实例的,输出为true
        System.out.println(person1 == person2);
    }

    @Test
    public void test03(){
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig2.class);
        /**
         * 在IDEA中切换Linux环境,Edit Configurations ==> VM options ==> 输入:-Dos.name=Linux
         */
        //动态获取环境变量的值:Window 10
        Environment environment = context.getEnvironment();
        String property = environment.getProperty("os.name");
        System.out.println(property);

        System.out.println("====================");

        String[] beanNamesForType = context.getBeanNamesForType(Person.class);
        for (String name : beanNamesForType){
            System.out.println(name);
        }

        System.out.println("====================");

        Map<String, Person> beansOfType = context.getBeansOfType(Person.class);
        System.out.println(beansOfType);
    }

    @Test
    public void testImport(){
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig2.class);
        printBeans(context);

        System.out.println("====================");

        System.out.println(context.getBean(Blue.class));

        System.out.println("====================");

        Object colorBean1 = context.getBean("colorFactoryBean");
        Object colorBean2 = context.getBean("colorFactoryBean");
        System.out.println(colorBean1 == colorBean2);
        //工厂bean获取的是调用getObject创建的对象
        System.out.println("bean的类型: " + colorBean1.getClass());

        //如果想获取colorFactoryBean()这个方法的bean,需要在方法名前加&标识即可
        Object colorBean3 = context.getBean("&colorFactoryBean");
        System.out.println(colorBean3.getClass());
    }

    public void printBeans(ApplicationContext context){
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String name : beanDefinitionNames){
            System.out.println(name);
        }
    }
}
