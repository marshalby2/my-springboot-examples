package com.my.springboot.bean;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @Description TODO
 * @Author marshal
 * @Date 4/9/20 11:52 AM
 */
@Entity
@Data
public class Role {

    @Id
    @GeneratedValue
    private int id;
    private String name;


}
