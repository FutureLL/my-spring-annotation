package com.atguigu.service;

import com.atguigu.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * @author Mr.Li
 * @version 1.0
 * @Description:
 * @Modified By:
 * @date 2019/11/30 17:30
 */
@Service
public class BookService {

    //@Qualifier("bookDao")
    //@Autowired
    //@Resource(name = "bookDao2")
    @Inject
    public BookDao bookDao;

    public void print(){
        System.out.println(bookDao);
    }

    @Override
    public String toString() {
        return "BookService{" +
                "bookDao=" + bookDao +
                '}';
    }
}
