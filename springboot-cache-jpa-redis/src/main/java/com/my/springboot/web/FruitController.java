package com.my.springboot.web;

import com.my.springboot.domain.Fruit;
import com.my.springboot.service.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * @Description TODO
 * @Author marshal
 * @Date 11/12/19 5:23 PM
 */
@RestController
@RequestMapping("/fruit")
public class FruitController {

    @Autowired
    private FruitService service;


    @GetMapping("/page")
    public Page<Fruit> page(int current, int size) {
        return service.queryPage(current, size);
    }


    @GetMapping("/queryById")
    public Fruit queryById(Integer id) {
        return service.queryOne(id);
    }

    @PostMapping("/saveOrUpdate")
    public void saveOrUpdate(Fruit fruit) {
        service.saveOrUpdate(fruit);
    }



    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable  Integer id) {
        service.delete(id);
    }



}
