package com.atguigu.config;

import com.atguigu.bean.Yellow;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;

import javax.sql.DataSource;

/**
 * Profile: Spring为我们提供的可以根据当前环境,动态的激活和切换一些列组件的功能
 *
 * 开发环境、测试环境、生产环境
 *
 * @Profile: 指定组件在那个环境的情况下才能被注册到容器中,不指定的情况下: 任何环境下都能注册.
 *           加了环境标识的bean只有这个环境被激活的时候才会生效,否则都不会生效.
 *       1> @Profile("default"): 默认只有标注了 default 的 @Profile 注解才会注册到容器中
 *       2> @Profile 写在配置类上,只有是指定的环境的时候,整个配置类里面的所有的配置才会生效,与指定方式的第二种配合使用
 *       3> 没有标注环境标识环境的bean在任何环境下都是加载的
 *          //@Profile("test")
 *          @Bean
 *          public Yellow yellow(){
 *              return new Yellow();
 *          }
 *
 *
 *      指定方式:
 *          1> 使用命令行动态参数,在虚拟机参数位置添加: -Dspring.profiles.active=test[环境标识]
 *          2> 使用代码的方式激活某种环境
 *              //1、创建一个AnnotationConfigApplicationContext对象
 *              AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
 *              //2、设置需要激活的环境,可以一次性激活多个环境
 *              context.getEnvironment().setActiveProfiles("test","Dev");
 *              //3、注册主配置类
 *              context.register(MainConfigOfProfile.class);
 *              //4、启动刷新容器
 *              context.refresh();
 */
//@Profile("test")
@PropertySource("classpath:/dbConfig.properties.")
@Configuration
public class MainConfigOfProfile implements EmbeddedValueResolverAware {

    @Value("${db.user}")
    private String user;

    private StringValueResolver resolver;

    private String driverClass;

    @Profile("test")
    @Bean
    public Yellow yellow(){
        return new Yellow();
    }

    // @Profile("default")
    @Profile("test")
    @Bean("testDataSource")
    public DataSource dataSource(@Value("${db.password}") String pwd) throws Exception {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(pwd);
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
        dataSource.setDriverClass(driverClass);
        return dataSource;
    }

    @Profile("Dev")
    @Bean("devDataSource")
    public DataSource dataSourceDev(@Value("${db.password}") String pwd) throws Exception {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(pwd);
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/jdbc");
        dataSource.setDriverClass(driverClass);
        return dataSource;
    }

    @Profile("Prod")
    @Bean("prodDataSource")
    public DataSource dataSourcePro(@Value("${db.password}") String pwd) throws Exception {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(pwd);
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/practice");
        dataSource.setDriverClass(driverClass);
        return dataSource;
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        this.resolver = resolver;
        driverClass = resolver.resolveStringValue("${db.driverClass}");
    }
}
