package com.gaoty.ssm.manager.book.impl;

import com.gaoty.ssm.manager.book.BookManager;
import com.gaoty.ssm.manager.book.dataobject.BookDO;
import com.gaoty.ssm.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author gaoty
 * @version V1.0
 * @decription
 * @create on 2018/3/26 10:55
 */
@Service
public class BookManagerImpl implements BookManager {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public BookDO queryById(long id) {
        return bookMapper.queryById(id);
    }

    @Override
    public List<BookDO> queryAll(int offset, int limit) {
        return bookMapper.queryAll(offset,limit);
    }

    @Override
    public int reduceNumber(long bookId) {
        return 0;
    }
}
