package com.kgc.lo.service;

import com.kgc.lo.pojo.User;

import java.util.List;

public interface UserService {
    List<User> login(String username,String password);
    List<User> selectAll();
}
