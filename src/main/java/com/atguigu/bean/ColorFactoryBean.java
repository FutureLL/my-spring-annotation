package com.atguigu.bean;

import org.springframework.beans.factory.FactoryBean;

// 创建一个Spring定义的工厂Bean
public class ColorFactoryBean implements FactoryBean<Color> {

    // 返回Color对象,添加到容器中
    @Override
    public Color getObject() throws Exception {
        System.out.println("ColorFactoryBean...getObject()...");
        return new Color();
    }

    // 返回对象的类型
    @Override
    public Class<?> getObjectType() {
        return Color.class;
    }

    /**
     * 是否为单例
     * true: 这个bean是单实例的,在容器中保存一份
     * false: 这个bean是多实例的,每次获取都会创建一个新的
     */
    @Override
    public boolean isSingleton() {
        return false;
    }
}
