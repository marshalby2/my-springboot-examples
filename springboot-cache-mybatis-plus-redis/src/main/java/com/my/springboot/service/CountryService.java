package com.my.springboot.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.my.springboot.domain.Country;
import org.springframework.data.domain.Page;

/**
 * @Description TODO
 * @Author marshal
 * @Date 11/14/19 8:41 AM
 */
public interface CountryService {

    void saveOrUpdate(Country country);

    Page<Country> queryPage();

    Country queryById(Integer id);

    void delete(Integer id);
}
