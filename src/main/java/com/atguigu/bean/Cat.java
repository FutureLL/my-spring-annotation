package com.atguigu.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @author Mr.Li
 * @version 1.0
 * @Description:
 * @Modified By:
 * @date 2019/12/1 7:12
 */

@Component
public class Cat implements InitializingBean, DisposableBean {

    public Cat(){
        System.out.println("Cat...constructor...创建对象");
    }

    //销毁方法
    public void destroy() throws Exception {
        System.out.println("Cat...destroy...");
    }

    //初始化方法
    public void afterPropertiesSet() throws Exception {
        System.out.println("Cat...afterPropertiesSet...");
    }
}
