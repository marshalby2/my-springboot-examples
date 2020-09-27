package com.my;

import com.my.bean.Goods;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @Description TODO
 * @Author marshal
 * @Date 27/9/20 4:04 PM
 */
@SpringBootTest
public class RedisTemplateTest {

    @Autowired
    private RedisTemplate<String, String> template;

    @Autowired
    private RedisTemplate<String, Goods> goodsRedisTemplate;

    @Test
    public void testSave() {
        template.opsForValue().set("name", "Tom");
    }

    @Test
    public void testGoodsSave() {
        var goods = Goods.builder().id(1L).name("运动鞋").brand("LiNing").build();
        goodsRedisTemplate.opsForValue().set("goods:" + goods.getId(), goods);
    }
}
