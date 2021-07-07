package com.soul.dynamicProxy;

import com.soul.staticProxy2.UserService;
import com.soul.staticProxy2.UserServiceImpl;

public class Client {
    public static void main(String[] args) {
        // 真实角色
        UserServiceImpl userService = new UserServiceImpl();
        // 代理角色创建
        ProxyInvocationHandler pih = new ProxyInvocationHandler();
        // 设置要被代理的对象
        pih.setTarget(userService);
        // 动态生成代理类
        UserService proxy = (UserService) pih.getProxy();

        proxy.query();


    }
}
