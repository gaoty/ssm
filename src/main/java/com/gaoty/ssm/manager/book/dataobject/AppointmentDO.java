package com.gaoty.ssm.manager.book.dataobject;


import java.util.Date;

/**
 * @author gaoty
 * @version V1.0
 * @decription
 * @create on 2018/3/23 16:52
 */

public class AppointmentDO {
    private long bookId;// 图书ID

    private long studentId;// 学号

    private Date appointTime;// 预约时间

    // 多对一的复合属性
    private BookDO book;// 图书实体

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public Date getAppointTime() {
        return appointTime;
    }

    public void setAppointTime(Date appointTime) {
        this.appointTime = appointTime;
    }

    public BookDO getBook() {
        return book;
    }

    public void setBook(BookDO book) {
        this.book = book;
    }
}
