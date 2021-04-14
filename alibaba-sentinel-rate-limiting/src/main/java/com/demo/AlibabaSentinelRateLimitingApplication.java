package com.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wujiawei
 * @see
 * @since 2021/4/14 下午1:32
 */
@SpringBootApplication
public class AlibabaSentinelRateLimitingApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(AlibabaSentinelRateLimitingApplication.class, args);
    }
    
    @Slf4j
    @RestController
    static class EchoController {
        
        @GetMapping("echo")
        public String echo() {
            return "echo";
        }
        
    }
    
}
