package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@SpringBootApplication
public class AlibabaNacosDiscoveryServerApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(AlibabaNacosDiscoveryServerApplication.class, args);
    }
    
    @Slf4j
    @RestController
    static class TestController {
    
        @GetMapping("/echo/{message}")
        public String hello(@PathVariable String message){
            log.info("invoke message = {}", message);
            return "[echo] : " + message;
        }
        
    }
    
}
