package com.my.springboot.service;

import com.my.springboot.domain.Fruit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

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
