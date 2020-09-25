package com.kgc.service;

import com.kgc.pojo.User;

/**
 * @author shkstart
 */
public interface UserService {
    User selectByName(String name);
}
