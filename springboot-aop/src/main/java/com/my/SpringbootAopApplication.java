package com.my;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
//@MapperScan(value = {"com.gitee.sunchenbin.mybatis.actable.dao.*", "com.my.*"})
//@ComponentScan(basePackages = {"com.gitee.sunchenbin.mybatis.actable.manager.*", "com.my.*"})
public class SpringbootAopApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootAopApplication.class, args);
    }

}
