package com.gaoty.ssm;

import com.gaoty.ssm.manager.book.dataobject.BookDO;
import com.gaoty.ssm.mapper.BookMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author gaoty
 * @version V1.0
 * @decription
 * @create on 2018/3/23 17:40
 */

public class BookMapperTest extends BaseTest {
    @Autowired
    private BookMapper bookMapper;

    @Test
    public void testQueryById() throws Exception {
        long bookId = 1000;
        BookDO book = bookMapper.queryById(bookId);
        System.out.println(book);
    }

    @Test
    public void testQueryAll() throws Exception {
        List<BookDO> books = bookMapper.queryAll(0, 4);
        for (BookDO book : books) {
            System.out.println(book);
        }
    }

    @Test
    public void testReduceNumber() throws Exception {
        long bookId = 1000;
        int update = bookMapper.reduceNumber(bookId);
        System.out.println("update=" + update);
    }
}
