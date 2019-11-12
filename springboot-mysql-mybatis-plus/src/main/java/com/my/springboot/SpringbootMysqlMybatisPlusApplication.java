package com.my.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.my.springboot.mapper")
public class SpringbootMysqlMybatisPlusApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMysqlMybatisPlusApplication.class, args);
    }

}
