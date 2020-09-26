package com.my.service.impl;

import com.my.bean.Poem;
import com.my.reponsitory.PoemRepository;
import com.my.service.PoemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    public void delete(Poem poem) {
        poemRepository.delete(poem);
    }

    @Override
    public Poem findById(Long id) {
        return poemRepository.findById(id).orElse(null);
    }

    @Override
    public Iterable<Poem> findAll() {
        return poemRepository.findAll();
    }

    @Override
    public Page<Poem> page(Integer current, Integer size) {
        var request = PageRequest.of(current, size);
        return poemRepository.findAll(request);
    }
}
