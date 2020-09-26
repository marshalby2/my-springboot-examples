package com.my.service.impl;

import com.my.bean.Poem;
import com.my.reponsitory.PoemRepository;
import com.my.service.PoemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description TODO
 * @Author marshal
 * @Date 26/9/20 7:40 PM
 */
@Service
public class PoemServiceImpl implements PoemService {

    @Autowired
    private PoemRepository poemRepository;

    @Override
    public void save(Poem poem) {
        poemRepository.save(poem);
    }

    @Override
    public Poem findByTitle(String title) {
        return null;
    }
}
