package com.my.springbootnacosconfig;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
// 使用 @NacosPropertySource 加载 dataId 为 example 的配置源，并开启自动更新
@NacosPropertySource(dataId = "nacos-config-demo.properties", autoRefreshed = true)
public class SpringbootNacosConfigApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringbootNacosConfigApplication.class, args);
        String userName = applicationContext.getEnvironment().getProperty("user.name");
        String userAge = applicationContext.getEnvironment().getProperty("user.age");
        System.err.println("user name :" + userName + "; age: " + userAge);
    }

}
