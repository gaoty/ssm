package com.gaoty.ssm.mapper;

import com.gaoty.ssm.manager.book.dataobject.AppointmentDO;
import org.apache.ibatis.annotations.Param;

/**
 * @author gaoty
 * @version V1.0
 * @decription
 * @create on 2018/3/23 17:05
 */

public interface AppointmentMapper {
    /**
     * 插入预约图书记录
     *
     * @param bookId
     * @param studentId
     * @return 插入的行数
     */
    int insertAppointment(@Param("bookId") long bookId, @Param("studentId") long studentId);

    /**
     * 通过主键查询预约图书记录，并且携带图书实体
     *
     * @param bookId
     * @param studentId
     * @return
     */
    AppointmentDO queryByKeyWithBook(@Param("bookId") long bookId, @Param("studentId") long studentId);

}
