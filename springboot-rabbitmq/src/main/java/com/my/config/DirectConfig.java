package com.my.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description TODO
 * @Author marshal
 * @Date 28/9/20 8:52 PM
 */
@Configuration
public class DirectConfig {


    @Bean
    public Queue logQueueA() {
        return new Queue("logQueueA");
    }

    @Bean
    public Queue logQueueB() {
        return new Queue("logQueueB");
    }

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange("direct.logs");
    }


    /**
     * logQueueA 和 error 日志绑定
     *
     * @return
     */
    @Bean
    public Binding bindingExchangeErrorLogs() {
        return BindingBuilder.bind(logQueueA()).to(directExchange()).with("error");
    }


    /**
     * logQueueB 和 error 日志绑定
     *
     * @return
     */
    @Bean
    public Binding bindingExchangeMixLogsA() {
        return BindingBuilder.bind(logQueueB()).to(directExchange()).with("error");
    }

    /**
     * logQueueB 和 info 日志绑定
     *
     * @return
     */
    @Bean
    public Binding bindingExchangeMixLogsB() {
        return BindingBuilder.bind(logQueueB()).to(directExchange()).with("info");
    }


}
