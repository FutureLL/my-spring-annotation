package com.atguigu.aop;

/**
 * @description:
 * @author: Mr.Li
 * @date: Created in 2020/2/21 15:21
 * @version: 1.0
 * @modified By:
 */
public class MathCalculateImpl implements MathCalculate {

    @Override
    public int div(int i, int j) {
        return i / j;
    }
}
