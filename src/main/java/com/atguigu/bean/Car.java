package com.atguigu.bean;

import org.springframework.stereotype.Component;

/**
 * @author Mr.Li
 * @version 1.0
 * @Description:
 * @Modified By:
 * @date 2019/12/1 6:28
 */

@Component
public class Car {

    public Car(){
        System.out.println("Car...Constructor...创建对象");
    }

    public void init(){
        System.out.println("Car...Init...");
    }

    public void destroy(){
        System.out.println("Car...destroy...");
    }
}
