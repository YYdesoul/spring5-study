package com.soul.staticProxy;

public class Client {
    public static void main(String[] args) {
//        without proxy
//        Host host = new Host();
//        host.rent();
        // 代理可以做一些被代理对象做不了的事情
        Proxy proxy = new Proxy(new Host());
        proxy.rent();
    }
}
