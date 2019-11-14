package com.my.springboot.repository;

import com.my.springboot.domain.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Description TODO
 * @Author marshal
 * @Date 11/12/19 5:18 PM
 */
public interface FruitRepository extends JpaRepository<Fruit, Integer> {
}
