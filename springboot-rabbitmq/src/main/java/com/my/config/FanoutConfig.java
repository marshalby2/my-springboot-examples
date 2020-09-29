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
 * 这种模式就是广播模式
 */
@Configuration
public class FanoutConfig {

    @Bean
    public Queue broadcastQueueA() {
        return new Queue("broadcastQueueA");
    }

    @Bean
    public Queue broadcastQueueB() {
        return new Queue("broadcastQueueB");
    }

    @Bean
    public Queue broadcastQueueC() {
        return new Queue("broadcastQueueC");
    }

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanout.broadcast");
    }


    @Bean
    public Binding bindingExchangeMessageA() {
        return BindingBuilder.bind(broadcastQueueA()).to(fanoutExchange());
    }

    @Bean
    public Binding bindingExchangeMessageB() {
        return BindingBuilder.bind(broadcastQueueB()).to(fanoutExchange());
    }

    @Bean
    public Binding bindingExchangeMessageC() {
        return BindingBuilder.bind(broadcastQueueC()).to(fanoutExchange());
    }
}
