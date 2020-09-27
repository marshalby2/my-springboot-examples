package com.my.config;

import com.my.bean.Goods;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.io.Serializable;

/**
 * @Description TODO
 * @Author marshal
 * @Date 27/9/20 4:14 PM
 */
@Configuration
public class RedisConfig {


    /**
     *  自定义 RedisTemplate , 因为默认只支持RedisTemplate<String,String>类型的，
     *  如果不重新设置，直接注入我们想要的类型，如下所示
     * @Autowired
     *  RedisTemplate<Long, Goods> template;
     *
     *  这种会报错的
     *
     *
     * @param redisConnectionFactory
     * @return
     */
    @Bean
    public RedisTemplate<String, Goods> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Goods> template = new RedisTemplate<>();
        // 设置 key 序列化器
        template.setKeySerializer(new StringRedisSerializer());
        // 设置 value 序列化器
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        template.setConnectionFactory(redisConnectionFactory);
        return template;
    }
}
