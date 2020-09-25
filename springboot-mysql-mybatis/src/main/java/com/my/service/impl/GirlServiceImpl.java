package com.my.service.impl;

import com.my.bean.Girl;
import com.my.mapper.GirlMapper;
import com.my.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description TODO
 * @Author marshal
 * @Date 25/8/20 8:00 PM
 */
@Service
public class GirlServiceImpl implements GirlService {

    @Autowired
    private GirlMapper girlMapper;

    @Override
    public Girl query(int id) {
        return girlMapper.query(id);
    }

    @Override
    public List<Girl> queryList() {
        return girlMapper.queryList();
    }

    @Override
    public void save(Girl girl) {
        if (girl != null && girl.getId() > 0) {
            // 更新
            girlMapper.update(girl);
        } else {
            girlMapper.insert(girl);
        }
    }

    @Override
    public void delete(int id) {
        girlMapper.delete(id);
    }
}
