package com.gaoty.ssm.manager.book.dataobject;


/**
 * @author gaoty
 * @version V1.0
 * @decription 图书实体类
 * @create on 2018/3/23 16:50
 */

public class BookDO {
    private long bookId;// 图书ID

    private String name;// 图书名称

    private int number;// 馆藏数量

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
