package com.gaoty.ssm.manager.book.dataobject;

import lombok.Data;

import java.awt.print.Book;
import java.util.Date;

/**
 * @author gaoty
 * @version V1.0
 * @decription
 * @create on 2018/3/23 16:52
 */
@Data
public class AppointmentDO {
    private long bookId;// 图书ID

    private long studentId;// 学号

    private Date appointTime;// 预约时间

    // 多对一的复合属性
    private Book book;// 图书实体
}
