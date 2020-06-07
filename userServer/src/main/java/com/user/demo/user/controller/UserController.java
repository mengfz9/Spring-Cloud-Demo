package com.user.demo.user.controller;

import com.user.demo.user.service.UserService;
import com.user.demo.user.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "user/{username}")
    public UserVo getUser(@PathVariable("username") String username){
        return userService.getUser(username);
    }
}
