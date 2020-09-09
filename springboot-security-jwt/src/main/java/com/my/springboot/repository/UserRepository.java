package com.my.springboot.repository;

import com.my.springboot.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Description TODO
 * @Author marshal
 * @Date 4/9/20 11:15 AM
 */
public interface UserRepository extends JpaRepository<User, Integer> {
}
