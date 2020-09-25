package com.my.web;

import com.my.domain.Book;
import com.my.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description TODO
 * @Author marshal
 * @Date 11/8/19 3:56 PM
 */
@Controller
public class TBookController {
    @Autowired
    private BookService service;

    @GetMapping(value = {("/"), ("")})
    public String index() {
        return "redirect:/list";
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<Book> list = this.service.findList();
        model.addAttribute("books", list);
        return "book/book_list";
    }

    @GetMapping("/toAdd")
    public String toAdd() {
        return "book/book_add";
    }

    @PostMapping("/add")
    public String add(Book book) {
        this.service.save(book);
        return "redirect:/list";
    }


    @GetMapping("/toEdit")
    public String toEdit(Model model, Long id) {
        Book book = this.service.findById(id);
        model.addAttribute("book", book);
        return "book/book_edit";
    }

    @PostMapping("/edit")
    public String edit(Book book) {
        this.service.edit(book);
        return "redirect:/list";
    }

    @RequestMapping("/delete")
    public String delete( Long id) {
        this.service.delete(id);
        return "redirect:/list";
    }


}
