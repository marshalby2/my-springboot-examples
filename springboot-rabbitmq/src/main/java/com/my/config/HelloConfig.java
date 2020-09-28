package com.my.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description TODO
 * @Author marshal
 * @Date 28/9/20 7:52 PM
 */
@Configuration
public class HelloConfig {
    @Bean
    public Queue helloQueue() {
        return new Queue("hello");
    }
}
