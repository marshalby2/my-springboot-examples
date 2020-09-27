package com.my.service;

import com.my.bean.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;

/**
 * @Description TODO
 * @Author marshal
 * @Date 27/9/20 9:08 AM
 */
public interface GoodsService {

    void save(Goods goods);

    Goods findById(Long id);
}
