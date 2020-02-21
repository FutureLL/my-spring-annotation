package com.atguigu.aop;

/**
 * @description:
 * @author: Mr.Li
 * @date: Created in 2020/2/21 15:12
 * @version: 1.0
 * @modified By:
 */
public class TraditionalWayProxyTest {

    public static void main(String[] args) {
        MathCalculate target = new MathCalculateImpl();

        MathCalculate proxy = new TraditionalWayProxy(target).getProxy();

        int result = proxy.div(4, 2);
        System.out.println("result = " + result);
    }
}
