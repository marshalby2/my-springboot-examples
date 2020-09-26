package com.my.service;

import com.my.bean.Poem;

/**
 * @Description TODO
 * @Author marshal
 * @Date 26/9/20 7:39 PM
 */
public interface PoemService {

    public void save(Poem poem);

    public Poem findByTitle(String title);

}
