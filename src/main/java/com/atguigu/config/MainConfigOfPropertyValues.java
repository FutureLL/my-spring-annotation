package com.atguigu.config;

import com.atguigu.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 配置类 == 配置文件,所以 @PropertySource 注解需要在配置类中
 *
 * 使用 @PropertySource 读取外部配置文件中的 key/value 保存的运行的环境变量中
 * 加载完外部配置文件以后使用${}取出配置文件中的值
 * 并且 @PropertySource 注解是一个可重复使用的注解 ===> PropertySources.class
 */
@PropertySource(value = {"classpath:/person.properties"})
@Configuration
public class MainConfigOfPropertyValues {

    @Bean
    public Person person(){
        return new Person();
    }
}
