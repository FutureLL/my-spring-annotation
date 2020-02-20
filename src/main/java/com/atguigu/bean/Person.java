package com.atguigu.bean;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author Mr.Li
 * @version 1.0
 * @Description:
 * @Modified By:
 * @date 2019/11/30 16:33
 */
public class Person {

    /**
     * 使用@Value进行赋值
     * 1、基本数值
     * 2、可以写SpEL,#{}
     * 3、可以写${},去出配置文件【properties】中的值(在运行的环境变量中的值)
     */
    @Value(value = "张三")
    private String name;
    @Value(value = "#{20-8}")
    private Integer age;
    @Value("${person.nickName}")
    private String nickName;

    public Person(){
        super();
    }

    public Person(String name, Integer age) {
        super();
        this.name = name;
        this.age = age;
    }

    public Person(String name, Integer age, String nickName) {
        super();
        this.name = name;
        this.age = age;
        this.nickName = nickName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
