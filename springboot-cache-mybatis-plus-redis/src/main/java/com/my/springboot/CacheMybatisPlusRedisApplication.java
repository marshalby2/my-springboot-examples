package com.my.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CacheMybatisPlusRedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(CacheMybatisPlusRedisApplication.class, args);
    }

}
