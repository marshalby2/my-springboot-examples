package com.my.service;

import com.my.domain.Fruit;
import org.springframework.data.domain.Page;

/**
 * @Description TODO
 * @Author marshal
 * @Date 11/12/19 5:17 PM
 */
public interface FruitService {

    Fruit queryOne(Integer id);

    Page<Fruit> queryPage(int current, int size);

    void saveOrUpdate(Fruit fruit);

    void delete(Integer id);

}
