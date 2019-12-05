package com.atguigu.bean;

/**
 * @author Mr.Li
 * @version 1.0
 * @Description:
 * @Modified By:
 * @date 2019/11/30 21:54
 */
public class Color {

    private Car car;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Color{" +
                "car=" + car +
                '}';
    }
}
