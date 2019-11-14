package com.my.springboot.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.my.springboot.domain.Country;
import com.my.springboot.mapper.CountryMapper;

/**
 * @Description TODO
 * @Author marshal
 * @Date 11/14/19 2:12 PM
 */
public class BaseServiceImpl extends ServiceImpl<CountryMapper, Country> implements IService<Country> {

}
