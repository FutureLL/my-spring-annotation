package com.atguigu.config;

import com.atguigu.aop.LogAspects;
import com.atguigu.aop.MathCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @description:
 * @author: Mr.Li
 * @date: Created in 2019/12/4 19:00
 * @version: 1.0
 * @modified By: Mr.Li
 *
 * AOP【动态代理】:
 *      指在程序运行期间动态的将某段代码切入到指定方法指定的位置进行运行的编程方式
 *
 * 1、导入Aop模块,Spring对Aop也做了简化操作,只要用到几个注解就可以了
 * 2、定义一个业务逻辑类(MathCalculator),在业务逻辑运行的时候将日志进行打印(方法之前,方法运行结束,方法运行异常,xxxx)
 * 3、定义一个日志切面类(LogAspects),切面里面的类需要动态感知(MathCalculator.div)运行到哪里,然后执行
 *    通知方法:
 *        前置通知(@Before): logStart(),在目标方法(div)运行之前运行
 *        后置通知(@After): logEnd(),在目标方法(div)运行之后运行【无论方法正常结束还是异常结束】
 *        返回通知(@AfterReturning): logReturn(),在目标方法(div)正常返回之后运行
 *        异常通知(@AfterThrowing): logException(),在目标方法(div)出现异常之后运行
 *        环绕通知(@Around): 动态代理,手动推目标方法运行(joinPoint.proceed())
 * 4、给切面类的方法标注何时何地运行(通知注解)
 * 5、将切面类和业务逻辑类(目标方法所在的类)都加入到容器中
 * 6、必须告诉Spring那个类是切面类(给切面类加一个注解@Aspect)
 * 7、给配置类中加@EnableAspectJAutoProxy【开启基于注解的Aop模式】
 *    在Spring中有很多的@EnableXXXX,开启某一项功能
 *
 * 三步:
 *    1> 将业务逻辑组件和切面类都加入到容器中,并且要告诉Spring那个是切面类(@Aspect)
 *    2> 在切面类上每个通知方法都要标注通知注解,告诉Spring何时何地运行(切入点表达式)
 *    3> 开启基于注解的Aop模式: @EnableAspectJAutoProxy
 *
 *
 *
 */

@EnableAspectJAutoProxy
@Configuration
public class MainConfigOfAOP {

    //把业务逻辑类加入到容器中
    @Bean
    public MathCalculator calculator(){
        return new MathCalculator();
    }

    //把切面类加入到容器中
    @Bean
    public LogAspects aspects(){
        return new LogAspects();
    }
}
