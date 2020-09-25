package com.kgc.lo.service.impl;

import com.kgc.lo.mapper.UserMapper;
import com.kgc.lo.pojo.User;
import com.kgc.lo.pojo.UserExample;
import com.kgc.lo.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.sound.midi.Soundbank;
import java.util.List;
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;
    @Override
    public List<User> login(String username, String password) {
        System.out.println("账号:"+username);
        System.out.println("密码："+password);
        UserExample example=new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andNameEqualTo(username);
        criteria.andPasswordEqualTo(password);
        List<User> userList = userMapper.selectByExample(example);
        return userList;
    }

    @Override
    public List<User> selectAll() {
        List<User> userList = userMapper.selectByExample(null);
        return userList;
    }
}
