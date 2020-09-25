package com.my.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @Description TODO
 * @Author marshal
 * @Date 11/12/19 4:37 PM
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
//@JsonIgnoreProperties(value={"hibernateLazyInitializer"})
public class Fruit implements Serializable {
    private static final long serialVersionUID = 8752425314417022954L;
    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String englishName;
    @Column
    private String chineseName;

}
