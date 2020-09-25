package com.kgc.service;

import com.kgc.pojo.User;

/**
 * @author shkstart
 * @create 2020-09-24 19:52
 */
public interface UserService {
    User selectByName(String name);
}
