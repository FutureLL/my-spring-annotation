package com.atguigu;

import com.atguigu.bean.Person;
import com.atguigu.config.MainConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {

        /**
         * //使用xml的方式注册bean
         * ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
         * Person person = (Person) context.getBean("person");
         * System.out.println(person);
         */

        /**
         * ApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
         * //使用id名称获取
         * Person person1 = (Person) context.getBean("person");
         * //使用类型获取
         * Person person2 = context.getBean(Person.class);
         * System.out.println(person1);
         * System.out.println(person2);
         *
         * //获取类的id名称
         * String[] beanNamesForType = context.getBeanNamesForType(Person.class);
         * for (String name : beanNamesForType){
         *     System.out.println(name);
         * }
         */
    }
}
