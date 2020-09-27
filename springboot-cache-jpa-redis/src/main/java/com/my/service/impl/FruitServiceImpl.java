package com.my.service.impl;

import com.my.repository.FruitRepository;
import com.my.bean.Fruit;
import com.my.service.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * @Description TODO
 * @Author marshal
 * @Date 11/12/19 5:21 PM
 */
@Service
public class FruitServiceImpl implements FruitService {

    private final static String cacheName = "fruit";
    private final static String cachePageName = "fruit:page";

    @Autowired
    private FruitRepository repository;

    @Override
    @Cacheable(cacheNames = cacheName ,key = "#id")
    public Fruit queryOne(Integer id) {
        return repository.getOne(id);
    }

    @Override
    @Cacheable(cacheNames = cachePageName, key = "'current' + #current +'size' + #size")
    public Page<Fruit> queryPage(int current, int size) {
        return repository.findAll(PageRequest.of(current, size));
    }

    @Override
    @Caching(evict = {
            @CacheEvict(value = cacheName, key = "#fruit.id"),
            @CacheEvict(value = cachePageName, allEntries = true),
    })
    public void saveOrUpdate(Fruit fruit) {
        repository.save(fruit);
    }

    @Override
    @Caching(evict = {
            @CacheEvict(value = cacheName, key = "#id"),
            @CacheEvict(value = cachePageName, allEntries = true),
    })
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
