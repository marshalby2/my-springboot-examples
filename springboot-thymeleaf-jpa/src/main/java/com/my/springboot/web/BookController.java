package com.my.springboot.web;

import com.my.springboot.domain.Book;
import com.my.springboot.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description TODO
 * @Author marshal
 * @Date 11/8/19 5:45 PM
 */
@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService service;

    @PostMapping("/add")
    public Book add(Book book) {
        this.service.save(book);
        return book;
    }

    @PutMapping("/edit")
    public Book update(Book book) {
        this.service.edit(book);
        return book;
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        this.service.delete(id);
    }


    @GetMapping("/findByAuthor")
    public List<Book> findByAuthor(String author) {
        return this.service.findByAuthor(author);
    }

    @GetMapping("/findAll")
    public List<Book> findAll() {
        return this.service.findList();
    }
}
