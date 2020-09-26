package com.my.reponsitory;

import com.my.bean.Poem;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @Description TODO
 * @Author marshal
 * @Date 26/9/20 7:37 PM
 */
public interface PoemRepository extends ElasticsearchRepository<Poem, Integer> {
}
