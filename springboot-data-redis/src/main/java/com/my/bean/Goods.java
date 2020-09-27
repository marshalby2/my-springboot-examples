package com.my.bean;

import lombok.*;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * @Description TODO
 * @Author marshal
 * @Date 27/9/20 9:07 AM
 */
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Goods implements Serializable {
    private static final long serialVersionUID = 1876144947167048601L;
    private Long id;
    private String name;
    private Double price;
    private String brand;
}
