package com.user.demo.user.service;

import com.user.demo.user.dao.UserDao;
import com.user.demo.user.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    /**
     * 通过用户名和密码查询用户
     * @param username
     * @param
     * @return
     */
    public UserVo getUser(String username){
        return userDao.getUser(username);
    }
}
