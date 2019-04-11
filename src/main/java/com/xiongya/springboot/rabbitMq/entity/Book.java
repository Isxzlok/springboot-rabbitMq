package com.xiongya.springboot.rabbitMq.entity;

/**
 * @Author xiongzhilong
 * @Email 2584496774@qq.com
 * @Date create by 2019-04-10 19:19
 */
public class Book {

    private String bookName;

    private String autor;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Book(){

    }

    public Book(String bookName, String autor){
        this.bookName = bookName;
        this.autor = autor;
    }
}
