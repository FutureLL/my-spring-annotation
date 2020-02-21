package com.atguigu.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;

import java.util.Arrays;

/**
 * 切面类
 *
 * @Aspect: 告诉Spring当前类是一个切面类
 * @Order: 使用@Order注解指定切面的优先级,值越小优先级越高
 */

@Order(value = 1)
@Aspect
public class LogAspects {

    /**
     * 抽取公共切入点表达式
     * 1、本类引用: logStart()、logEnd()、logException
     * 2、其他的切面引入: logReturn()
     * <p>
     * public int com.atguigu.aop.MathCalculator.*(..)
     * public: 访问修饰符,("里边写切入表达式")
     * int: 返回值类型
     * *: 表示MathCalculator类中的所有方法
     * (..): 任意参数
     */
    @Pointcut("execution(public int com.atguigu.aop.MathCalculator.*(..))")
    public void pointCut() {

    }

    /**
     * 这个@Before是org.aspectj.lang.annotation.Before的
     *
     * @Before: 切入时机, 在目标方法之前切入
     * <p>
     * 注意: JoinPoint必须出现在参数的第一位,否则Spring是无法识别的
     */
    @Before(value = "pointCut()")
    public void logStart(JoinPoint joinPoint) {
        //获取参数列表
        Object[] argsList = joinPoint.getArgs();
        //joinPoint.getSignature().getName(): 获得方法名
        System.out.println(joinPoint.getSignature().getName() + " 方法运行...@Before: 参数列表是:{ " + Arrays.asList(argsList) + " }");
    }

    @After("pointCut()")
    public void logEnd(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName() + " 方法结束...@After");
    }

    @AfterReturning(value = "com.atguigu.aop.LogAspects.pointCut()", returning = "result")
    public void logReturn(JoinPoint joinPoint, Object result) {
        System.out.println(joinPoint.getSignature().getName() + " 方法正常返回...@AfterReturning: 计算结果:{ " + result + " }");
    }

    @AfterThrowing(value = "pointCut()", throwing = "exception")
    public void logException(JoinPoint joinPoint, Exception exception) {
        System.out.println(joinPoint.getSignature().getName() + " 方法异常...异常信息:{" + exception + "}");
    }

    /**
     * 环绕通知,需要携带ProceedingJoinPoint类型的参数
     * 环绕通知类似于动态代理的全过程: ProceedingJoinPoint类型的参数可以决定是否执行目标方法
     * 且环绕通知必须有返回值,返回值即为目标方法的返回值
     */
    @Around(value = "pointCut()")
    public Object logAround(ProceedingJoinPoint proceedingJoinPoint) {
        try {
            // 前置通知
            System.out.println("The method " + proceedingJoinPoint.getSignature().getName() +
                    " begins with " + Arrays.asList(proceedingJoinPoint.getArgs()));
            // 后置通知
            // proceed(): Proceed with the next advice or target method invocation
            System.out.println("The method " + proceedingJoinPoint.getSignature().getName() +
                    " ends with " + proceedingJoinPoint.proceed());
        } catch (Throwable throwable) {
            // 异常通知
            System.out.println("The method " + proceedingJoinPoint.getSignature().getName() +
                    " occurs exception: " + throwable);
        }
        // 后置通知
        System.out.println("The method " + proceedingJoinPoint.getSignature().getName() + " ends ");
        return 520;
    }
}

