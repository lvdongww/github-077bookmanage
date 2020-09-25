package com.kgc.lo.service;

import com.kgc.lo.pojo.Book;

import java.util.List;

public interface BookService {
    List<Book> selectAll();
    int insert(Book book);
    int del(int id);
    Book selectById(int id);
    int update(Book book);
}
