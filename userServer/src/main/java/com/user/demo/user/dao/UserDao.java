package com.user.demo.user.dao;

import com.user.demo.user.vo.UserVo;

public interface UserDao {

    UserVo getUser(String username);
}
