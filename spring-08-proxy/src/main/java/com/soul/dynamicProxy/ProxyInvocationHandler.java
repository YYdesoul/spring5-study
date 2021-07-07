package com.soul.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// 用这个类自动生成代理类
public class ProxyInvocationHandler implements InvocationHandler {

    // 被代理对象
    private Object target;

    public void setTarget(Object target) {
        this.target = target;
    }

    // 生成代理对象
    public Object getProxy() {
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    // 处理代理实例并返回结果
    // 调用代理类的方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log(method.getName());
        Object result = method.invoke(target, args);
        return result;
    }

    public void log(String msg) {
        System.out.println("execute " + msg + " method." );
    }
}
