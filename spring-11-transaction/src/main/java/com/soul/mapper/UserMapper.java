package com.soul.mapper;

import com.soul.pojo.User;

import java.util.List;

public interface UserMapper {

    List<User> getUserList();

    int addUser(User user);

    int deleteById(int id);
}
