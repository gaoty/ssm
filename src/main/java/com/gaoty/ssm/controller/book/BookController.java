package com.gaoty.ssm.controller.book;

import com.gaoty.ssm.manager.book.BookManager;
import com.gaoty.ssm.manager.book.dataobject.BookDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author gaoty
 * @version V1.0
 * @decription
 * @create on 2018/3/26 10:57
 */
@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookManager bookManager;

    @ResponseBody
    @RequestMapping("/queryById")
    public BookDO queryById(long id) {
        return bookManager.queryById(id);
    }
}
