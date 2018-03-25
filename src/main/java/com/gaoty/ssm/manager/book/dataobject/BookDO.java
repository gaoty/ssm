package com.gaoty.ssm.manager.book.dataobject;

import lombok.Data;

/**
 * @author gaoty
 * @version V1.0
 * @decription 图书实体类
 * @create on 2018/3/23 16:50
 */
@Data
public class BookDO {
    private long bookId;// 图书ID

    private String name;// 图书名称

    private int number;// 馆藏数量

}
