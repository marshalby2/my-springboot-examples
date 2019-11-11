package com.my.springboot.reponsitory;

import com.my.springboot.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Description TODO
 * @Author marshal
 * @Date 11/8/19 3:56 PM
 */
public interface BookRepository extends JpaRepository<Book, Long> {


    /**
     *  根据作者查询
     *
     * @param author
     * @return
     */
    List<Book> findByAuthor(String author);

}
