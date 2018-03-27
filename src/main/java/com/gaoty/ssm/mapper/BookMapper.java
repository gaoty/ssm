package com.gaoty.ssm.mapper;

import com.gaoty.ssm.manager.book.dataobject.BookDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author gaoty
 * @version V1.0
 * @decription
 * @create on 2018/3/23 17:05
 */

public interface BookMapper {
    /**
     * 通过ID查询单本图书
     *
     * @param id
     * @return
     */
    BookDO queryById(long id);

    /**
     * 查询所有图书
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return
     */
    List<BookDO> queryAll(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * 减少馆藏数量
     *
     * @param bookId
     * @return 如果影响行数等于>1，表示更新的记录行数
     */
    int reduceNumber(long bookId);
}
