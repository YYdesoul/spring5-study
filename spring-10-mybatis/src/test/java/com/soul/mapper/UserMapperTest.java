package com.soul.mapper;

import com.soul.pojo.User;
import com.soul.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOError;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapperTest {
//    @Test
//    public void testGetUserList() {
//        // 1. 获得SqlSession对象
//        SqlSession sqlSession = MybatisUtils.getSqlSession();
//
//        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//        List<User> userList = userMapper.getUserList();
//
//        for (User user : userList) {
//            System.out.println(user);
//        }
//
//        sqlSession.close();
//    }

    @Test
    public void testSpringMyBatis() throws IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        UserMapper userMapper = context.getBean("userMapper", UserMapper.class);
        for (User user : userMapper.getUserList()) {
            System.out.println(user);
        }
    }

    @Test
    public void testSpringMyBatis2() throws IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        UserMapper userMapper2 = context.getBean("userMapper2", UserMapper.class);
        List<User> userList = userMapper2.getUserList();
        for (User user : userList) {
            System.out.println(user);
        }
    }

}
