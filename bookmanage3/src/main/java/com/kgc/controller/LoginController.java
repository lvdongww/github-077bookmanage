package com.kgc.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kgc.pojo.Book;
import com.kgc.pojo.User;
import com.kgc.service.BookService;
import com.kgc.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shkstart
 */
@Controller
public class LoginController {
    @Resource
    UserService userService;

    @RequestMapping("/")
    public String Login() {
        return "login";
    }

    @RequestMapping("/toIndex")
    public String toIndex(String name, String password, Model model) {
        if (name != null) {
            User user = userService.selectByName(name);
            if (user.getPassword().equals(password)) {

            } else {
                model.addAttribute("error", "用户名或密码不正确!");
                return "login";
            }
        } else {
            model.addAttribute("error", "用户名或密码不正确!");
            return "login";
        }
        return "index";
    }
}