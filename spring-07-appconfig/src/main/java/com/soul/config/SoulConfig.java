package com.soul.config;

import com.soul.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration //代表这是一个配置类
@ComponentScan("com.soul.pojo")   // 扫描
@Import(SoulConfig2.class)    // import 另一个配置类
public class SoulConfig {

    @Bean //通过方法注册一个bean，这里的返回值就Bean的类型，方法名就是bean的id!
    public User getUser() {
        return new User();
    }
}
