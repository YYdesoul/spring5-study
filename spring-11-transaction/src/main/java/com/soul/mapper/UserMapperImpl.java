package com.soul.mapper;

import com.soul.pojo.User;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

public class UserMapperImpl extends SqlSessionDaoSupport implements UserMapper{

    @Override
    public List<User> getUserList() {
        addUser(new User(10, "Jack", "haha"));
        deleteById(10);
        return getSqlSession().getMapper(UserMapper.class).getUserList();
    }

    @Override
    public int addUser(User user) {
        return getSqlSession().getMapper(UserMapper.class).addUser(user);
    }

    @Override
    public int deleteById(int id) {
        return getSqlSession().getMapper(UserMapper.class).deleteById(id);
    }


}
