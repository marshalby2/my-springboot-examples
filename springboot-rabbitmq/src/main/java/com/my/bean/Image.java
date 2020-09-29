package com.my.bean;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Description TODO
 * @Author marshal
 * @Date 29/9/20 4:31 PM
 */
@Builder
@ToString
@Getter
public class Image implements Serializable {
    private static final long serialVersionUID = 8617592564349459927L;
    private String type;
    private int size;
}
