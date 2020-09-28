package com.my.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description TODO
 * @Author marshal
 * @Date 28/9/20 10:18 AM
 */
@Configuration
public class HelloConfig {


    @Bean
    public Queue queue() {
        return new Queue("hello");
    }

}
