package com.kgc.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kgc.mapper.BookMapper;
import com.kgc.pojo.Book;
import com.kgc.service.BookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author shkstart
 */
@Service("bookService")
public class BookServiceImpl implements BookService {
    @Resource
    BookMapper bookMapper;

    @Override
    public PageInfo<Book> selectAll(Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        PageHelper.orderBy("id desc");
        List<Book> books = bookMapper.selectByExample(null);
        PageInfo<Book> pageInfo = new PageInfo<>(books);
        return pageInfo;
    }

    @Override
    public int add(Book book) {
        return bookMapper.insertSelective(book);
    }

    @Override
    public Book selectById(Integer id) {
        Book book = bookMapper.selectByPrimaryKey(id);
        return book;
    }

    @Override
    public int delete(Integer id) {
        return bookMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(Book book) {
        return bookMapper.updateByPrimaryKeySelective(book);
    }
}
