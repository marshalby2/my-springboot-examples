package com.my;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan("com.my.springboot.mapper")
@EnableSwagger2
public class SpringbootMysqlMybatisPlusApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMysqlMybatisPlusApplication.class, args);
    }

}
