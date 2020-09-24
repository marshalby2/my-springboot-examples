package com.my.service;

import com.mongodb.client.result.UpdateResult;
import com.my.bean.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ExecutableFindOperation;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @Description TODO
 * @Author marshal
 * @Date 24/9/20 7:17 PM
 */
@Service
public class BookService {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     *  保存
     *
     * @param book
     */
    public void save(Book book) {
        mongoTemplate.save(book);
    }


    /**
     *  根据名字查询
     *
     * @param name
     * @return
     */
    public Book findByName(String name) {
       return mongoTemplate.findOne(Query.query(Criteria.where("name").is(name)), Book.class);
    }

    /**
     *  查询所有
     *
     * @return
     */
    public List<Book> findAll() {
        return mongoTemplate.findAll(Book.class);
    }

    /**
     *  更新
     *
     * @param book
     */
    public void update(Book book) {
        var query = Query.query(Criteria.where("id").is(book.getId()));
        var update = Update.update("name", book.getName()).set("author", book.getAuthor())
                .addToSet("description", book.getDescription());
        mongoTemplate.updateFirst(query, update, Book.class);
    }


    /**
     *  删除
     *
     * @param id
     */
    public void delete(Integer id) {
        mongoTemplate.remove(Query.query(Criteria.where("_id").is(id)), Book.class);
    }


}
