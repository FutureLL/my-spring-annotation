package com.atguigu.config;

import com.atguigu.bean.Color;
import com.atguigu.bean.ColorFactoryBean;
import com.atguigu.bean.Person;
import com.atguigu.bean.Red;
import com.atguigu.condition.LinuxCondition;
import com.atguigu.condition.MyImportBeanDefinitionRegistrar;
import com.atguigu.condition.MyImportSelector;
import com.atguigu.condition.WindowCondition;
import org.springframework.context.annotation.*;


/**
 * @Scope: 指定作用范围,ConfigurableBeanFactory 类中可以找到可以写的参数
 *      singleton: 单实例的(默认值),Ioc容器启动会调用方法创建对象放到Ioc容器中,
 *                 以后每次获取都从容器(map.get())中拿即可
 *      prototype: 多实例的,Ioc容器启动并不会调用方法创建对象放在容器中,
 *                 而是在每次获取的时候才会调用方法创建对象,而且每次获取都会创建一次对象
 *      request: 同一次请求创建一个实例
 *      session: 同一个session创建一个实例
 *
 * @Lazy: 单实例bean中,默认在Ioc容器启动的时候创建对象,而使用@Lazy容器启动不创建对象,
 *      在第一次使用(获取)bean的时候创建对象,并初始化,并且只会创建一次
 *
 * @Conditional: 可以配置在方法上,也可以配置在类上,
 *      如果在方法上,表示只要满足当前条件,该方法才能生效
 *      如果在类上,表示类中的组件统一设置,只有这个类满足当前条件,这个类中的配置的所有bean注册才能生效
 *
 * @Import: 快速的给容器中导入组件,id默认为组件的全类名com.atguigu.bean.Color,
 *      {Color.class, Red.class}: 导入多个组件
 */
@Conditional({WindowCondition.class})
@Configuration
@Import({Color.class, Red.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
public class MyConfig2 {

    //默认是单实例的,也就是说使用getBean()获取到的两个Person对象是相等的
    @Bean("person2")
    //@Scope("prototype")
    @Lazy
    public Person person(){
        System.out.println("给容器中添加Person...");
        return new Person("小雷",24);
    }

    /**
     * @Conditional({Condition[]}): 按照一定条件,进行判断,满足条件给容器中注册bean
     *
     * 要求: 如果是Win系统,给容器中注册bill,如果是Linux系统,给容器中注册linus
     */
    @Conditional({WindowCondition.class})
    @Bean("bill")
    public Person person01(){
        return new Person("Bill Gates",62);
    }

    @Conditional({LinuxCondition.class})
    @Bean("linus")
    public Person person02(){
        return new Person("Linus",48);
    }

    /**
     * 给容器中注册组件也就是bean
     *  1、包扫描+组件标注注解(@Controller/@Service/@Repository/@Component)[只局限于我们自己写的类]
     *  2、@Bean[导入第三方包组件]
     *  3、@Import[快速的给容器中导入组件]
     *      1> @Import(xxx.class) / @Import({xxx.class,xxx1.class}),容器中就会自动注册这些组件,id默认为全类名
     *      2> ImportSelector: 返回需要导入的组件的全类名数组
     *      3> ImportBeanDefinitionRegistrar: 手动注册bean到容器中
     *  4、使用Spring提供的FactoryBean(工厂bean)
     *      1> 默认获取到的是工厂bean调用getObject创建的对象
     *      2> 如果要获取工厂Bean本身,需要给id前加一个&标识即可
     */
    @Bean
    public ColorFactoryBean colorFactoryBean(){
        return new ColorFactoryBean();
    }
}
