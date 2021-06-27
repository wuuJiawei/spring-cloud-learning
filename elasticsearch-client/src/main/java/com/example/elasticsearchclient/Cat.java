package com.example.elasticsearchclient;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @author wujiawei
 * @see
 * @since 2021/6/26 9:40 下午
 */
@Data
@Document(indexName = "cat", useServerConfiguration = true)
public class Cat {

    @Id
    private Long id;

    private String name;
    
    private String color;
    
    @Version
    private Long version;
}
