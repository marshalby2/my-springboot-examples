package com.my.service.impl;

import com.my.bean.Goods;
import com.my.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @Description TODO
 * @Author marshal
 * @Date 27/9/20 3:39 PM
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private RedisTemplate<String, Goods> template;

    @Override
    public void save(Goods goods) {
        template.opsForValue().set("goods:" + goods.getId(), goods);
    }

    @Override
    public Goods findById(Long id) {
        return template.opsForValue().get("goods:" + id);
    }
}
