package com.my.springboot.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * @Description TODO
 * @Author marshal
 * @Date 11/8/19 3:34 PM
 */
@Entity
public class Book {

    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false, unique = true)
    private String bookName;
    @Column(nullable = false)
    private String author;
    @Column(nullable = false)
    private String region;
    @Column
    private String description;
    @Column
    private String specification;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }
}
