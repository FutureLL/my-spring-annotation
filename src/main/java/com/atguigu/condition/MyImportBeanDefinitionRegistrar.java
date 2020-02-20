package com.atguigu.condition;

import com.atguigu.bean.RainBow;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author Mr.Li
 * @version 1.0
 * @Description:
 * @Modified By:
 * @date 2019/11/30 22:30
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    /**
     * AnnotationMetadata: 当前类的注解信息
     * BeanDefinitionRegistry: BeanDefinition注册类
     * <p>
     * 把所有需要添加到容器中的bean,调用BeanDefinitionRegistry.registerBeanDefinition()手工注册
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        boolean red = registry.containsBeanDefinition("com.atguigu.bean.Red");
        boolean blue = registry.containsBeanDefinition("com.atguigu.bean.Blue");
        if (red && blue) {
            //指定bean的定义信息,也就是bean的类型,bean的作用域等等
            RootBeanDefinition beanDefinition = new RootBeanDefinition(RainBow.class);
            /**
             * registerBeanDefinition(): 注册bean
             * 指定bean名
             */
            registry.registerBeanDefinition("自定义: rainBow", beanDefinition);
        }
    }
}
