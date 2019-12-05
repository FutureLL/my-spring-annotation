package com.atguigu.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Mr.Li
 * @version 1.0
 * @Description:
 * @Modified By:
 * @date 2019/12/1 19:15
 */

//默认加在Ioc容器中的组件,容器启动会调用无参构造器,创建对象,再进行初始化、赋值操作
@Component
public class Boss {

    private Car car;

    /**
     * 构造器要用的组件,都是从容器中获取
     */
//    @Autowired
    public Boss(@Autowired Car car){
        this.car = car;
        System.out.println("Boss...有参构造器...");
    }

    public Car getCar() {
        return car;
    }

    /**
     * 标注在方法上,Spring容器创建当前对象,就会调用方法,完成赋值
     * 方法使用的参数,自定义类型的值从Ioc容器中获取
     */
    //@Autowired
    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Boss{" +
                "car=" + car +
                '}';
    }
}
