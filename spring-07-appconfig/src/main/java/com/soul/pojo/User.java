package com.soul.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


// 等价于 <bean id="user" class="com.soul.pojo.User/>
// @Component组件
@Component
public class User {
//    @Value("David")
    // 相当于配置文件中 <property name="name" value="David"/>
    public String name;

    @Value("David")
    // 相当于配置文件中 <property name="name" value="David"/>
    public void setName(String name) {
        this.name = name;
    }
}
