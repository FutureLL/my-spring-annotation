package com.atguigu.config;

import com.atguigu.bean.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * bean的生命周期:
 *      bean的创建 --- 初始化 --- 销毁的过程
 * 现在由容器管理bean的生命周期,
 * 我们可以自定义初始化和销毁方法,容器在bean进行到当前生命周期的时候来调用我们自定义的初始化和销毁方法
 *
 * 构造(对象创建):
 *      单实例:在容器启动的时候创建对象
 *      多实例:在每次获取的时候创建对象
 *
 * 初始化之前: BeanPostProcessor.postProcessBeforeInitialization()
 * 初始化:
 *      对象创建好完成,并赋值好,调用初始化方法
 * 初始化之后: BeanPostProcessor.postProcessAfterInitialization()
 * 销毁:
 *      单实例: 是在容器关闭的时候进行销毁
 *      多实例: 容器不会管理这个bean,也就是说容器不会调用这个销毁方法
 *
 *
 *
 *      1、指定初始化和销毁方法                                                       ===> Car.class
 *          通过@Bean注解的方式指定 init-method(初始化) 和 destroy-method(销毁)
 *      2、通过Bean实现 InitializingBean(定义初始化逻辑),DisposableBean(定义销毁逻辑)  ===> Cat.class
 *      3、可以使用JSR250规范定义的注解:                                              ===> Dog.class
 *          @PostConstruct: 在bean创建完成并且属性赋值完成,来执行初始化方法
 *          @PreDestroy: 在容器销毁bean之前通知我们进行清理工作
 *      4、BeanPostProcessor【interface】: bean的后置处理器                           ===> MyBeanPostProcessor.class
 *          在bean初始化前后进行一些处理工作
 *          postProcessBeforeInitialization: 在初始化之前工作
 *          postProcessAfterInitialization: 在初始化之后工作
 */
@ComponentScan(value = "com.atguigu.bean")
@Configuration
public class MainConfigOfLifeCycle {

    //@Scope("prototype")
    @Bean(initMethod = "init", destroyMethod = "destroy")
    public Car car(){
        return new Car();
    }
}
