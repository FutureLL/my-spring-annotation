package com.atguigu.controller;

import com.atguigu.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author Mr.Li
 * @version 1.0
 * @Description:
 * @Modified By:
 * @date 2019/11/30 17:30
 */
@Controller
public class BookController {

    @Autowired
    private BookService bookService;
}
