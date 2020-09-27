package com.my.service.impl;

import com.my.repository.BookRepository;
import com.my.bean.Book;
import com.my.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @Description TODO
 * @Author marshal
 * @Date 11/8/19 4:09 PM
 */
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository repository;

    @Override
    public void save(Book book) {
        this.repository.save(book);
    }

    @Override
    public void edit(Book book) {
        this.repository.save(book);
    }

    @Override
    public void delete(Long id) {
        this.repository.deleteById(id);
    }

    @Override
    public List<Book> findList() {
        return this.repository.findAll();
    }

    @Override
    public Book findById(Long id) {
        Optional<Book> optionalBook = this.repository.findById(id);
        return optionalBook.get();
    }

    @Override
    public List<Book> findByAuthor(String author) {
        return this.repository.findByAuthor(author);
    }
}
