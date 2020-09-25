package com.kgc.service;

import com.github.pagehelper.PageInfo;
import com.kgc.pojo.Book;

/**
 * @author shkstart
 * @create 2020-09-24 20:00
 */
public interface BookService {
    PageInfo<Book> selectAll(Integer pageIndex, Integer pageSize);

    int add(Book book);

    Book selectById(Integer id);

    int delete(Integer id);

    int update(Book book);
}
