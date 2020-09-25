package com.my.web;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.my.domain.Country;
import com.my.service.CountryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@RequestMapping("/country")
@Api(value = "CountryController")
public class CountryController {
    private final static String cacheName = "country";
    private final static String cachePageName = "country:page";

    @Autowired
    private CountryService service;

    /**
     *  根据ID查询
     *
     *  添加缓存
     *
     * @param id
     * @return
     */
    @GetMapping("/queryById")
    @ApiOperation(value = "根据ID查询")
    @Cacheable(cacheNames = cacheName ,key = "#id")
    public R<Object> queryById(Integer id) {
        return R.ok(this.service.getById(id));
    }


    /**
     *  分页查询
     *
     *  添加缓存
     *
     * @param current
     * @param size
     * @return
     */
    @GetMapping("/page")
    @ApiOperation(value = "分页")
    @Cacheable(cacheNames = cachePageName, key = "'current' + #current +'size' + #size")
    public R page(int current, int size) {
        Page<Country> page = new Page<>();
        page.setCurrent(current);
        page.setSize(size);
        return R.ok(this.service.page(page, Wrappers.emptyWrapper()));
    }

    /**
     *  保存
     *
     *  清空缓存
     *
     * @param country
     * @return
     */
    @PostMapping("/save")
    @ApiOperation(value = "保存")
    @Caching(evict = {
            @CacheEvict(value = cacheName, key = "#country.id"),
            @CacheEvict(value = cachePageName, allEntries = true),
    })
    public R save(Country country) {
        return R.ok(this.service.saveOrUpdate(country));
    }

    /**
     *  删除
     *
     *  清空缓存
     *
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "根据ID删除")
    @Caching(evict = {
            @CacheEvict(value = cacheName, key = "#id"),
            @CacheEvict(value = cachePageName, allEntries = true),
    })
    public R delete(@PathVariable Integer id) {
        return R.ok(this.service.removeById(id));
    }



}
