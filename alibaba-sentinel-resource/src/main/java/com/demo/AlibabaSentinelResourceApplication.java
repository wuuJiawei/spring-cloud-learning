package com.demo;

import com.alibaba.csp.sentinel.annotation.aspectj.SentinelResourceAspect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author wujiawei
 * @see
 * @since 2021/4/14 下午5:05
 */
@SpringBootApplication
public class AlibabaSentinelResourceApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(AlibabaSentinelResourceApplication.class, args);
    }
    
    @Bean
    public SentinelResourceAspect sentinelResourceAspect() {
        return new SentinelResourceAspect();
    }
    
}
