package com.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wujiawei
 * @see
 * @since 2021/4/20 下午3:54
 */
@Slf4j
@SpringBootApplication
public class AlibabaSentinelDatasourceNacosApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(AlibabaSentinelDatasourceNacosApplication.class, args);
    }
    
    @RestController
    static class EchoController {
        
        @GetMapping("echo")
        public String echo() {
            return "echo controller";
        }
        
    }
    
}
