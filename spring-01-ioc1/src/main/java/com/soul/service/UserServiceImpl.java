package com.soul.service;

import com.soul.dao.MySqlDao;
import com.soul.dao.UserDao;

public class UserServiceImpl implements UserService{

//    非IOC的方式
//    UserDao userDao = new MySqlDao();

    // IOC原理原型
    UserDao userDao;
    @Override
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void getUser() {
        userDao.getUser();
    }
}
