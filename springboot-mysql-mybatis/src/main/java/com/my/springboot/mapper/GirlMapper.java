package com.my.springboot.mapper;

import com.my.springboot.bean.Girl;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description TODO
 * @Author marshal
 * @Date 25/8/20 7:57 PM
 */
//@Mapper
public interface GirlMapper {

    Girl query(@Param("id") int id);

    List<Girl> queryList();

    void insert(@Param("girl") Girl girl);

    void update(@Param("girl") Girl girl);

    void delete(@Param("id") int id);

}
