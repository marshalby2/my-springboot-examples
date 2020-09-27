package com.my.repository;

import com.my.bean.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Description TODO
 * @Author marshal
 * @Date 11/12/19 5:18 PM
 */
public interface FruitRepository extends JpaRepository<Fruit, Integer> {
}
