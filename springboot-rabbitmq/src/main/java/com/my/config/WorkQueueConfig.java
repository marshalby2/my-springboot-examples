package com.my.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description TODO
 * @Author marshal
 * @Date 28/9/20 7:53 PM
 */
@Configuration
public class WorkQueueConfig {
    @Bean
    public Queue workQueue() {
        return new Queue("workQueue");
    }
}
