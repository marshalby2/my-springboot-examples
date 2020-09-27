package com.my.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description TODO
 * @Author marshal
 * @Date 11/14/19 8:41 AM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Country implements Serializable {
    private static final long serialVersionUID = -2751797595289999456L;

    private Integer id;
    private String name;
    private String language;

}
