package com.soul.dao;

public class OracleDao implements UserDao{
    @Override
    public void getUser() {
        System.out.println("Oracle Users");
    }
}
