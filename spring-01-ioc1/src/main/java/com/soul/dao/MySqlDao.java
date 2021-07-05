package com.soul.dao;

public class MySqlDao implements UserDao{

    @Override
    public void getUser() {
        System.out.println("MySQL Users");
    }
}
