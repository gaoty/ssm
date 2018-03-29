package com.gaoty.ssm.controller.book;

import com.gaoty.ssm.manager.book.BookManager;
import com.gaoty.ssm.manager.book.dataobject.BookDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author gaoty
 * @version V1.0
 * @decription
 * @create on 2018/3/26 10:57
 */
@Slf4j
@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookManager bookManager;

    @RequestMapping("/queryById")
    public String queryById(ModelMap modelMap , long id) {
        log.info("»Î≤Œ£∫"+id);
        BookDO bookDO =  bookManager.queryById(id);
        modelMap.put("bookDo",bookDO);
        return "book/bookDetail";
    }
}
