package com.my.springboot.service.impl;

import com.my.springboot.domain.Country;
import com.my.springboot.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

/**
 * @Description TODO
 * @Author marshal
 * @Date 11/14/19 8:46 AM
 */
@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryCache countryCache;

    @Override
    public void saveOrUpdate(Country country) {

    }

    @Override
    public Page<Country> queryPage() {
        return null;
    }

    @Override
    public Country queryById(Integer id) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
