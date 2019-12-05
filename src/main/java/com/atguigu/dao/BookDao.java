package com.atguigu.dao;

import org.springframework.stereotype.Repository;

/**
 * @author Mr.Li
 * @version 1.0
 * @Description:
 * @Modified By:
 * @date 2019/11/30 17:32
 */
@Repository
public class BookDao {

    private String lable = "1";

    public String getLable() {
        return lable;
    }

    public void setLable(String lable) {
        this.lable = lable;
    }

    @Override
    public String toString() {
        return "BookDao{" +
                "lable='" + lable + '\'' +
                '}';
    }
}
