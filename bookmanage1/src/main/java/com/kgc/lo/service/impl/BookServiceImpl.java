package com.kgc.lo.service.impl;

import com.kgc.lo.mapper.BookMapper;
import com.kgc.lo.pojo.Book;
import com.kgc.lo.pojo.BookExample;
import com.kgc.lo.service.BookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service("bookService")
public class BookServiceImpl implements BookService {
    @Resource
    BookMapper bookMapper;
    @Override
    public List<Book> selectAll() {
        List<Book> books = bookMapper.selectByExample(null);
        return books;
    }

    @Override
    public int insert(Book book) {
        int i = bookMapper.insertSelective(book);
        return i;
    }

    @Override
    public int del(int id) {
        int i = bookMapper.deleteByPrimaryKey(id);
        return i;
    }

    @Override
    public Book selectById(int id) {
        Book book = bookMapper.selectByPrimaryKey(id);
        return book;
    }

    @Override
    public int update(Book book) {
        int i = bookMapper.updateByPrimaryKeySelective(book);
        return i;
    }
}
