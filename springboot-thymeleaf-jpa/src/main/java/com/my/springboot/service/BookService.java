package com.my.springboot.service;

import com.my.springboot.domain.Book;

import java.util.List;

/**
 * @Description TODO
 * @Author marshal
 * @Date 11/8/19 4:09 PM
 */
public interface BookService {

    void save(Book book);

    void edit(Book book);

    void delete(Long id);

    List<Book> findList();

    Book findById(Long id);

    List<Book> findByAuthor(String author);
}
