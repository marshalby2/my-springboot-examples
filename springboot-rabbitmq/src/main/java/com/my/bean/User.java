package com.my.bean;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Description TODO
 * @Author marshal
 * @Date 28/9/20 10:48 PM
 */
@Builder
@ToString
public class User implements Serializable {
    private static final long serialVersionUID = 4409039369681054682L;
    private String name;
    private int age;
}
