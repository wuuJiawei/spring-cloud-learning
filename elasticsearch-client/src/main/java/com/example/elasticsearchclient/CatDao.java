package com.example.elasticsearchclient;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author wujiawei
 * @see
 * @since 2021/6/26 9:42 下午
 */
public interface CatDao extends ElasticsearchRepository<Cat, Long> {

}
