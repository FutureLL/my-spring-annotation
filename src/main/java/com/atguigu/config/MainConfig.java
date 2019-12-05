package com.atguigu.config;

import com.atguigu.bean.Person;
import com.atguigu.service.BookService;
import org.springframework.context.annotation.*;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;

/**
 * 配置类 == 配置文件
 *
 * @Configuration: 告诉Spring这是一个配置类
 * @Bean: 给容器中注册一个bean,类型为返回值类型,id默认使用方法名作为id
 *      name = "person":指定bean的名字
 *
 * @ComponentScan: 包扫描,可以指定多个@ComponentScan用来指定不同的扫描策略
 *      value = "com.atguigu":指定要扫描的包
 *      excludeFilters = {
 *         @Filter(type = FilterType.ANNOTATION,classes = {Controller.class, Service.class})
*       }: 指定扫描的时候按照某些规则(这里是注解)排除那些组件
 *      includeFilters = {
 *         @Filter(type = FilterType.ANNOTATION,classes = Controller.class)
 *      }: 指定扫描的时候只需要包含那些组件
 *      useDefaultFilters = false: 禁用掉默认的规则,因为默认的规则就是扫描所有的,这样只包含才能生效
 *      type扫描类型:
 *          FilterType.ANNOTATION: 按照注解
 *          FilterType.ASSIGNABLE_TYPE: 按照我们给定的类型,只要是我们指定的组件都会被加载到容器中,例如:子类、实现类等等
 *          FilterType.ASPECTJ: 使用AspectJ表达式
 *          FilterType.REGEX: 使用正则表达式
 *          FilterType.CUSTOM:
 *
 * @ComponentScans(value = {}): 也可以使用这种方式进行指定多个不同的扫描策略,大括号中是多个@ComponentScan
 */
@Configuration
@ComponentScan(value = "com.atguigu",includeFilters = {
        @Filter(type = FilterType.ANNOTATION,classes = Controller.class),
        @Filter(type = FilterType.ASSIGNABLE_TYPE,classes = BookService.class),
        @Filter(type = FilterType.CUSTOM,classes = MyTypeFilter.class)},
        useDefaultFilters = false)
public class MainConfig {

    @Bean(name = "person1")
    public Person personConfig(){
        return new Person("李四",23);
    }
}
