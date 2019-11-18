package com.my.springboot.web;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.my.springboot.domain.Country;
import com.my.springboot.service.CountryService;
import org.omg.CORBA.OBJ_ADAPTER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.web.bind.annotation.*;

/**
 * @Description TODO
 * @Author marshal
 * @Date 11/14/19 8:45 AM
 */
@RestController
@RequestMapping("country")
public class CountryController {
    private final static String cacheName = "fruit";
    private final static String cachePageName = "fruit:page";

    @Autowired
    private CountryService service;

    @GetMapping("/queryById")
    @Cacheable(cacheNames = cacheName ,key = "#id")
    public R<Object> queryById(Integer id) {
        return R.ok(this.service.getById(id));
    }


    @GetMapping("/page")
    @Cacheable(cacheNames = cachePageName, key = "'current' + #current +'size' + #psize")
    public R page(int current, int size) {
        Page<Country> page = new Page<>();
        page.setCurrent(current);
        page.setSize(size);
        return R.ok(this.service.page(page, Wrappers.emptyWrapper()));
    }

    @PostMapping("/saveOrUpdate")
    @Caching(evict = {
            @CacheEvict(value = cacheName, key = "#country.id"),
            @CacheEvict(value = cachePageName, allEntries = true),
    })
    public R save(Country country) {
        return R.ok(this.service.saveOrUpdate(country));
    }

    @DeleteMapping("/delete/{id}")
    @Caching(evict = {
            @CacheEvict(value = cacheName, key = "#id"),
            @CacheEvict(value = cachePageName, allEntries = true),
    })
    public R delete(@PathVariable Integer id) {
        return R.ok(this.service.removeById(id));
    }



}
