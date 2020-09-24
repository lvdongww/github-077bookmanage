package com.kgc.controller;

import com.kgc.pojo.User;
import com.kgc.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @author shkstart
 * @create 2020-09-24 19:50
 */
@Controller
public class LoginController {
    @Resource
    UserService userService;
    @RequestMapping("/")
    public String toLogin(){
        return "index";
    }
    @RequestMapping("/doIndex")
    public String doIndex(String name, String password, Model model){
        if (name!=null){
            User user = userService.selectByName(name);
            if (user.getPassword().equals(password)){

            }else{
                model.addAttribute("error","用户名或密码不正确");
                return "index";
            }
        }else{
            model.addAttribute("error","用户名或密码不正确");
            return "index";
        }
        return "index2";
    }
}
