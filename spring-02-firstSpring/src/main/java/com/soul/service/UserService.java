package com.soul.service;

import com.soul.dao.UserDao;

public interface UserService {
    void getUser();

    void setUserDao(UserDao userDao);
}
