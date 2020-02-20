package com.atguigu.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * 切面类
 *
 * @Aspect: 告诉Spring当前类是一个切面类
 */

@Aspect
public class LogAspects {

    /**
     * 抽取公共切入点表达式
     * 1、本类引用: logStart()、logEnd()、logException
     * 2、其他的切面引入: logReturn()
     *
     *  public int com.atguigu.aop.MathCalculator.*(..)
     *      public: 访问修饰符,("里边写切入表达式")
     *      int: 返回值类型
     *      *: 表示MathCalculator类中的所有方法
     *      (..): 任意参数
     */
    @Pointcut("execution(public int com.atguigu.aop.MathCalculator.*(..))")
    public void pointCut(){

    }

    /**
     * 这个@Before是org.aspectj.lang.annotation.Before的
     * @Before: 切入时机,在目标方法之前切入
     *
     * 注意: JoinPoint必须出现在参数的第一位,否则Spring是无法识别的
     */
    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint){
        //获取参数列表
        Object[] argsList = joinPoint.getArgs();
        //joinPoint.getSignature().getName(): 获得方法名
        System.out.println(joinPoint.getSignature().getName() + " 方法运行...@Before: 参数列表是:{ " + Arrays.asList(argsList) + " }");
    }

    @After("pointCut()")
    public void logEnd(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature().getName() + " 方法结束...@After");
    }

    @AfterReturning(value = "com.atguigu.aop.LogAspects.pointCut()", returning = "result")
    public void logReturn(JoinPoint joinPoint,Object result){
        System.out.println(joinPoint.getSignature().getName() + " 方法正常返回...@AfterReturning: 计算结果:{ " + result + " }");
    }

    @AfterThrowing(value = "pointCut()", throwing = "exception")
    public void logException(JoinPoint joinPoint,Exception exception){
        System.out.println(joinPoint.getSignature().getName() + " 方法异常...异常信息:{" + exception + "}");
    }
}
