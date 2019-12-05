package com.atguigu.bean;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


/**
 * @author Mr.Li
 * @version 1.0
 * @Description:
 * @Modified By:
 * @date 2019/12/1 7:33
 */

@Component
public class Dog {

    public Dog(){
        System.out.println("Dog...constructor...创建对象");
    }

    //对象创建并赋值之后调用
    @PostConstruct
    public void init(){
        System.out.println("Dog...@PostConstruct...");
    }

    //容器移除对象之前
    @PreDestroy
    public void destroy(){
        System.out.println("Dog...@PreDestroy...");
    }
}
