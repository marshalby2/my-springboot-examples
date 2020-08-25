package com.my.springboot.service;

import com.my.springboot.bean.Girl;

import java.util.List;

/**
 * @Description TODO
 * @Author marshal
 * @Date 25/8/20 7:58 PM
 */
public interface GirlService {

    Girl query(int id);

    List<Girl> queryList();

    void save(Girl girl);

    void delete(int id);
}
