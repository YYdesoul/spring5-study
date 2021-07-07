package com.soul.service;

public class UserServiceImpl implements Userservice{
    @Override
    public void add() {
        System.out.println("added a user");
    }

    @Override
    public void delete() {
        System.out.println("deleted a user");

    }

    @Override
    public void update() {
        System.out.println("updated a user");
    }

    @Override
    public void select() {
        System.out.println("selected a user");
    }
}
