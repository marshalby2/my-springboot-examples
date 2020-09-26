package com.my.bean;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @Description TODO
 * @Author marshal
 * @Date 26/9/20 7:31 PM
 */
@Document(indexName = "poem")
@Data
public class Poem {

    @Id
    private Long id;
    private String title;
    private String dynasty;
    private String author;
    @Field(type = FieldType.Keyword)
    private String content;

}
