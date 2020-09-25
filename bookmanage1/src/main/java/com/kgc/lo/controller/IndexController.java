package com.kgc.lo.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kgc.lo.mapper.BookMapper;
import com.kgc.lo.pojo.Book;
import com.kgc.lo.pojo.User;
import com.kgc.lo.service.BookService;
import com.kgc.lo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class IndexController {
    @Resource
    UserService userService;
    @Resource
    BookService bookService;

    @RequestMapping("/")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("/doIndex")
    public String doIndex(String username, String password, Model model) {
        System.out.println("账号:" + username);
        System.out.println("密码:" + password);
        List<User> login = userService.login(username,password);
        login.toString();
        String error = null;
            if (login.size()>0) {
                String show="";
                   if(login.get(0).getUsertype()==1){
                       show="图书管理员欢迎您";
                   }else{
                       show="欢迎您光临图书系统";
                   }
                   model.addAttribute("show",show);
               return "index";
            } else {
                error = "账号或密码错误";
                int jie=1;
                model.addAttribute("jie",jie);
                model.addAttribute("error", error);
                return "login";
            }
    }
    @RequestMapping("/selectAll")
    @ResponseBody
    public Map<String,Object> selectAll(@RequestParam(defaultValue = "1")Integer pageIndex,@RequestParam(defaultValue = "2")  Integer pageSize){
        Map<String,Object> map=new HashMap<>();
        PageHelper.startPage(pageIndex,pageSize);
        List<Book> books = bookService.selectAll();
        PageInfo<Book> pageInfo = new PageInfo<>(books);
        map.put("data",pageInfo);
        return map;
    }
    @RequestMapping("/toadd")
    public String toadd(){
        return "add";
    }
    @RequestMapping("/add")
    public String add(Model model,Book book){
        System.out.println(book.toString());
        int insert = bookService.insert(book);
        String ajie="";
        if(insert>0){
            ajie="添加成功";
        }else{
            ajie="添加失败";
        }
        model.addAttribute("ajie",ajie);
        return "index";
    }
    @RequestMapping("/delete{id}")
    public Map<String,Object> delete(int id){
        Map<String,Object> map=new HashMap<>();
       String success="";
        int del = bookService.del(id);
        if(del>0){
            map.put("success","true");
        }else{
            map.put("success","false");
        }
        return map;
    }
    @RequestMapping("/chuan{id}")
    public String chuan(int id,Model model){
        Book book = bookService.selectById(id);
        model.addAttribute("book",book);
        return "update";
    }
    @RequestMapping("/update")
    public String update(Model model,Book book){
        int update = bookService.update(book);
        String ajie="";
        if(update>0){
            ajie="更改成功";
        }else{
            ajie="更改失败";
        }
        model.addAttribute("ajie",ajie);
        return "index";
    }
}
