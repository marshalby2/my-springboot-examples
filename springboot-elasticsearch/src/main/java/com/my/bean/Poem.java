package com.my.bean;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @Description TODO
 * @Author marshal
 * @Date 26/9/20 7:31 PM
 */
@Document(indexName = "poem")
@Data
public class Poem {

    private Integer id;
    private String title;
    private String dynasty;
    private String author;
    private String content;

}
