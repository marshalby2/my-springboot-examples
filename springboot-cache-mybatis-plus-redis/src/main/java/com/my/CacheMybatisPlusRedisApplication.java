package com.my;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
@EnableSwagger2Doc
@MapperScan("com.my.mapper")
public class CacheMybatisPlusRedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(CacheMybatisPlusRedisApplication.class, args);
    }

}
