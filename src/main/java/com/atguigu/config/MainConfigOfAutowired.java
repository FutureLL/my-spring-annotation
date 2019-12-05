package com.atguigu.config;

import com.atguigu.bean.Car;
import com.atguigu.bean.Color;
import com.atguigu.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * 自动装配: Spring利用依赖注入(DI),完成对Ioc容器中各个组件的依赖关系赋值
 *
 * 1、@Autowired: 自动注入,一个组件内部要用到另外一个组件,只需要给用到的那个组件属性上添加一个@Autowired注解即可
 *      1> 默认优先按照类型去容器中找对应的组件,找到就赋值
 *      2> 如果找到多个相同类型的组件,将属性的名称作为组件的id去容器中查找
 *      3> @Qualifier("bookDao"),使用@Qualifier指定需要装配的组件的id,而不是使用属性名
 *      4> 自动装配一定要将属性赋值好,没有就会报错,可以使用@Autowired(required = false)不会强制装配
 *      5> @Primary,让Spring自动装配的时候,默认使用装配首选的bean,也可以继续使用@Qualifier指定需要装配的bean的名字
 *       @Service
 *       public class BookService {
 *             @Qualifier("bookDao")
 *             //@Autowired(required = false)
 *             @Autowired
 *             public BookDao bookDao02;
 *      }
 *
 * 2、Spring还支持使用@Resource(JSR250)和@Inject(JSR330)[Java规范的注解]
 *      1> @Resource: 可以和Autowired一样实现自动装配功能,默认是按照组件名称进行装配的,
 *             没有能支持@Primary功能,也没有支持@Autowired(required = false)
 *      2> @Inject: 首先需要导入javax.inject包,和@Autowired功能一样,
 *             支持@Primary,但是不支持@Autowired(required = false)
 *  3、区别:
 *      最本质的区别:@Autowired由Spring定义的,而@Resource和@Inject都是Java规范
 *
 *  4、@Autowired: 构造器、参数、方法、属性,都是从容器中获取参数的值
 *      1> [标注在set方法上]
 *              @Autowired
 *              public void setCar(Car car){
 *                  this.car=car;
 *              }
 *
 *              //@Bean + 方法参数,参数从容器中获取,这些位置默认不写@Autowired效果是一样的都能自动装配
 *              @Bean
 *              public Color color(Car car){
 *                  Color color = new Color();
 *                  color.setCar(car);
 *                  return color;
 *              }
 *      2> [标注在有参构造上]
 *              @Autowired
 *              public Boss(Car car){
 *                  this.car = car;
 *                  System.out.println("Boss...有参构造器...");
 *              }
 *          注意: 如果组件只有一个有参构造器,这个有参构造器的@Autowired可以省略,参数位置的组件还是可以自动从容器中获取
 *       3> [标注在参数上]
 *              (@Autowired Car car): 标注在有参构造或者setter方法的参数上
 *
 *  5、自定义组件想要使用Spring容器底层的一些组件(ApplicationContext,BeanFactory,xxx),
 *     只需要自定义组件实现xxxAware,在创建对象的时候,会调用接口规定的方法注入相关组件,
 *     xxxAware,功能是使用xxxProcessor来处理的
 *          //把Spring底层一些组件注入到自定义的Bean中
 *          @Component
 *          public class Red implements ApplicationContextAware, BeanNameAware, EmbeddedValueResolverAware {
 *
 *          }
 */
@Configuration
@ComponentScan({"com.atguigu.service","com.atguigu.controller","com.atguigu.dao","com.atguigu.bean"})
public class MainConfigOfAutowired {

    //现在有两个BookDao,一个叫bookDao,一个叫bookDao2
    @Bean("bookDao2")
    @Primary
    public BookDao bookDao(){
        BookDao bookDao = new BookDao();
        bookDao.setLable("2");
        return bookDao;
    }

    /**
     * @Bean: 标注的方法,创建对象的时候,方法参数值从容器中获取
     */
    @Bean
    public Color color(Car car){
        Color color = new Color();
        color.setCar(car);
        return color;
    }
    
}
