package com.my.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.my.bean.Country;

/**
 * @Description TODO
 * @Author marshal
 * @Date 11/14/19 8:41 AM
 */
public interface CountryService extends IService<Country>{

    boolean saveOrUpdate(Country country);

    Country getById(Integer id);

    IPage<Country> page(int current, int size);

    boolean removeById(Integer id);
}
