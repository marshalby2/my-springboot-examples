package com.my.service;

import com.my.bean.Poem;
import org.springframework.data.domain.Page;

/**
 * @Description TODO
 * @Author marshal
 * @Date 26/9/20 7:39 PM
 */
public interface PoemService {

    void save(Poem poem);

    void delete(Poem poem);

    Poem findById(Long id);

    Iterable<Poem> findAll();

    Page<Poem> page(Integer current, Integer size);


}
