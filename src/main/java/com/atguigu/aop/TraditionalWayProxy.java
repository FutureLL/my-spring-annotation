package com.atguigu.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @description: 传统方式实现的代理
 * @author: Mr.Li
 * @date: Created in 2020/2/21 14:56
 * @version: 1.0
 * @modified By:
 */
public class TraditionalWayProxy {

    // 要代理的对象
    private MathCalculate target;

    public TraditionalWayProxy(MathCalculate target) {
        this.target = target;
    }

    public MathCalculate getProxy() {
        MathCalculate proxy = null;

        // 代理对象由哪一个类加载器负责加载
        ClassLoader loader = target.getClass().getClassLoader();
        // 代理对象的类型有哪些方法
        Class[] interfaces = new Class[]{MathCalculate.class};
        // 当调用代理对象其中的方法时,该执行的代码
        /**
         * Object proxy: 正在返回的代理对象.一般情况下,在invoke方法中都不适用该对象
         * Method method: 正在被调用的方法
         * Object[] args: 调用方法时传入的参数
         */
        InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                // 这里一般不直接使用 Object proxy,如果如下行代码,那么会形成死循环,造成内存溢出 StackOverflowError
                // System.out.println(proxy.toString());
                String methodName = method.getName();
                // 日志
                System.out.println("The method : " + methodName + " begins with " + Arrays.asList(args));
                // 执行方法
                Object result = method.invoke(target, args);
                // 日志
                System.out.println("The method " + methodName + " ends with " + result);
                return result;
            }
        };

        proxy = (MathCalculate) Proxy.newProxyInstance(loader,interfaces,invocationHandler);
        return proxy;
    }
}
