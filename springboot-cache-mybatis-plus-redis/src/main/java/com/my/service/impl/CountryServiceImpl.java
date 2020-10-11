package com.my.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.my.bean.Country;
import com.my.mapper.CountryMapper;
import com.my.service.CountryService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

/**
 * @Description TODO
 * @Author marshal
 * @Date 11/14/19 8:46 AM
 */
@Service
public class CountryServiceImpl extends ServiceImpl<CountryMapper, Country> implements CountryService {

    private final static String cacheName = "country";
    private final static String cachePageName = "country:page";


    /**
     * 更新或保存
     * <p>
     * 清空缓存
     *
     * @param country
     * @return
     */
    @Override
    @Caching(evict = {
            @CacheEvict(value = cacheName, key = "#country.id"),
            @CacheEvict(value = cachePageName, allEntries = true),
    })
    public boolean saveOrUpdate(Country country) {
        return super.saveOrUpdate(country);
    }

    /**
     * 根据ID查询
     * <p>
     * 新建缓存
     *
     * @param id
     * @return
     */
    @Override
    @Cacheable(cacheNames = cacheName, key = "#id")
    public Country getById(Integer id) {
        return super.getById(id);
    }

    /**
     * 分页查询
     * <p>
     * 建立缓存
     *
     * @param current
     * @param size
     * @return
     */
    @Override
    @Cacheable(cacheNames = cachePageName, key = "'current' + #current +'size' + #size")
    public IPage<Country> page(int current, int size) {
        Page<Country> page = new Page<>();
        page.setCurrent(current);
        page.setSize(size);
        return super.page(page, Wrappers.emptyWrapper());
    }

    /**
     * 根据ID删除
     * <p>
     * 清空缓存
     *
     * @param id
     * @return
     */
    @Override
    @Caching(evict = {
            @CacheEvict(value = cacheName, key = "#id"),
            @CacheEvict(value = cachePageName, allEntries = true),
    })
    public boolean removeById(Integer id) {
        return super.removeById(id);
    }
}
