package com.greendaodemo.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;

/**
 * Creator：YOOOOO on 2017/12/25 02:14
 * Mail：youchin_li@newsoft.com.tw
 **/


@Entity
public class Book {
    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookId=" + bookId +
                ", price='" + price + '\'' +
                '}';
    }

    @Id(autoincrement = true)
    private Long id;
    @NotNull
    private Long bookId;
    private String price;

    @Generated(hash = 584368170)
    public Book(Long id, @NotNull Long bookId, String price) {
        this.id = id;
        this.bookId = bookId;
        this.price = price;
    }

    @Generated(hash = 1839243756)
    public Book() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBookId() {
        return this.bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getPrice() {
        return this.price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}