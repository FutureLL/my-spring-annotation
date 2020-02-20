package com.atguigu.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

//判读是否为window系统
public class WindowCondition implements Condition {

    /**
     * ConditionContext: 判断条件能使用的上下文环境
     * AnnotatedTypeMetadata: 当前标注了@Conditional注解的注释信息
     */
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        //是否为Window系统
        //1、能获取到Ioc使用的BeanFactory
        ConfigurableListableBeanFactory beanFactory = conditionContext.getBeanFactory();
        //2、获取类加载器
        ClassLoader classLoader = conditionContext.getClassLoader();
        //3、获取当前环境信息
        Environment environment = conditionContext.getEnvironment();
        String property = environment.getProperty("os.name");
        if (property.contains("Window")){
            return true;
        }
        //4、获取到Bean定义的注册类
        BeanDefinitionRegistry registry = conditionContext.getRegistry();
        return false;
    }
}
