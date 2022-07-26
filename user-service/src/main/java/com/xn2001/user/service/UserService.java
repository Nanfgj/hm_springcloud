package com.xn2001.user.service;

import com.xn2001.user.mapper.UserMapper;
import com.xn2001.user.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User queryById(@PathVariable("id") Long id) {
        return userMapper.findById(id);
    }
}