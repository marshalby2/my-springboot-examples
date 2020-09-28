package com.my.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description TODO
 * @Author marshal
 * @Date 28/9/20 7:53 PM
 *
 * 这种模式就是发布订阅模式
 */
@Configuration
public class FanoutConfig {

    @Bean
    public Queue fanoutQueueA() {
        return new Queue("fanoutQueueA");
    }

    @Bean
    public Queue fanoutQueueB() {
        return new Queue("fanoutQueueB");
    }

    @Bean
    public Queue fanoutQueueC() {
        return new Queue("fanoutQueueC");
    }

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanoutExchange");
    }


    @Bean
    public Binding bindingExchangeMessageA() {
        return BindingBuilder.bind(fanoutQueueA()).to(fanoutExchange());
    }

    @Bean
    public Binding bindingExchangeMessageB() {
        return BindingBuilder.bind(fanoutQueueB()).to(fanoutExchange());
    }

    @Bean
    public Binding bindingExchangeMessageC() {
        return BindingBuilder.bind(fanoutQueueC()).to(fanoutExchange());
    }
}
