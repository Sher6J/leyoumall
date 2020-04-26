package com.leyou.search.repository;

import com.leyou.search.pojo.Goods;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author sher6j
 * @create 2020-04-26-18:53
 */
public interface GoodsRepository extends ElasticsearchRepository<Goods, Long> {
}
