package com.kgc.controller;

import com.github.pagehelper.PageInfo;
import com.kgc.pojo.Book;
import com.kgc.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author shkstart
 * @create 2020-09-24 20:00
 */
@Controller
public class BookController {
    @Resource
    BookService bookService;
    @RequestMapping("selectAll")
    @ResponseBody
    public Map<String,Object> selectAll(@RequestParam(defaultValue = "1") Integer pageIndex,@RequestParam(defaultValue = "2")  Integer pageSize){
        Map<String,Object> map=new HashMap<>();
        PageInfo<Book> pageInfo = bookService.selectAll(pageIndex, pageSize);
        map.put("data",pageInfo);
        return map;
    }
    @RequestMapping("toadd")
    public String toadd(){
        return "index4";
    }
    @RequestMapping("add")
    public String add(Book book){
        bookService.add(book);
        return "index2";
    }
    @RequestMapping("/chuan")
    public String chuan(Integer id, Model model){
        Book book = bookService.selectById(id);
        model.addAttribute("book",book);
        return "index3";
    }
    @RequestMapping("delete")
    @ResponseBody
    public Map<String,Object> delete(Integer id){
        Map<String,Object> map=new HashMap<>();
        int delete = bookService.delete(id);
        if (delete>0){
            map.put("success","true");
        }else{
            map.put("success","false");
        }
        return map;
    }
    @RequestMapping("update")
    public String xiu(Book book){
        bookService.update(book);
        return "index2";
    }
}
