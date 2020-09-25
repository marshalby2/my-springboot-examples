package com.my;

import com.my.domain.Fruit;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
class RedisApplicationTests {

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 设置
     */
    @Test
    void setKey() {
        ValueOperations vo = redisTemplate.opsForValue();
//        Fruit apple = new Fruit(1,"apple", "苹果");
//        vo.set("apple", apple);
//        Fruit banana = new Fruit(1,"banana", "香蕉");
//        vo.set("banana", banana);
        Fruit orange = new Fruit(1,"orange", "橘子");
        vo.set("orange", orange);
    }

    /**
     * 取值
     */
    @Test
    void getKey() {
        ValueOperations vo = redisTemplate.opsForValue();
//        Object apple = vo.get("apple");
        // Fruit(id=1, englishName=apple, chineseName=苹果)
//        System.out.println(apple);
//        System.out.println(vo.get("banana"));
        System.out.println(vo.get("orange"));
    }

    @Test
    void setSkey() {
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        ops.set("name", "Tom");
        ops.set("region", "American");
    }

    @Test
    void getSkey(){
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        System.out.println(ops.get("name") + " : " + ops.get("region"));
    }



}
