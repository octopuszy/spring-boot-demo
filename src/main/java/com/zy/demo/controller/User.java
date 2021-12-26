package com.zy.demo.controller;

import com.zy.demo.req.UserReq;
import com.zy.demo.req.scenes.Save;
import com.zy.demo.resp.CommonResp;
import com.zy.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class User {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public CommonResp<Object> login(@Validated UserReq req){
        CommonResp<Object> resp = new CommonResp<>();
        resp.setSuccess(userService.login(req));
        return resp;
    }

    @PostMapping("/register")
    public CommonResp<Object> register(@Validated({Save.class}) UserReq req){
        CommonResp<Object> resp = new CommonResp<>();
        resp.setSuccess(userService.register(req));
        return resp;
    }
}
