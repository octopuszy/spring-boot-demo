package com.zy.demo.service;

import com.zy.demo.mapper.UserMapper;
import com.zy.demo.req.UserReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public boolean register(UserReq re){
        return true;
    }

    public boolean login(UserReq re){
        return true;
    }
}
