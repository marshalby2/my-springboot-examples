package com.my.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description TODO
 * @Author marshal
 * @Date 28/9/20 10:49 PM
 */
@Configuration
public class UserConfig {

    @Bean
    public Queue userInfo() {
        return new Queue("user.info");
    }

    @Bean
    public TopicExchange userTopicExchange() {
        return new TopicExchange("topic.user");
    }

    @Bean
    public Binding bindingTopicExchange() {
        return BindingBuilder.bind(userInfo()).to(userTopicExchange()).with("user.info");
    }
}
