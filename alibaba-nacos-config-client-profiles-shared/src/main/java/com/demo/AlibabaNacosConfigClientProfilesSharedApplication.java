package com.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wujiawei
 * @see
 * @since 2021/4/12 下午9:21
 */
@SpringBootApplication
public class AlibabaNacosConfigClientProfilesSharedApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(AlibabaNacosConfigClientProfilesSharedApplication.class, args);
    }
    
    @Slf4j
    @RefreshScope
    @RestController
    static class EchoController {
    
        @Value("${title.en}")
        private String titleEn;
        
        @Value("${log}")
        private Boolean log;
        
        @GetMapping("echo")
        public String echo() {
            return titleEn + ", log = " + log;
        }
        
    }
    
}
