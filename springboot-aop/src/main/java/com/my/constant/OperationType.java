package com.my.constant;

import lombok.Getter;

/**
 * @author YangYunbo
 * @version 2021-06-08
 */
@Getter
public enum OperationType {

    ADD("增加操作"),
    QUERY("查询操作"),
    DELETE("删除操作"),
    UPDATE("修改操作"),
    OTHER("其他操作");

    private final String type;

    OperationType(String type) {
        this.type = type;
    }
}
