package com.example.alibabanacosdiscoveryclientcommon;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class AlibabaNacosDiscoveryClientCommonApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(AlibabaNacosDiscoveryClientCommonApplication.class, args);
    }
    
    @Slf4j
    @RestController
    static class RestTemplateController {
        
        @LoadBalanced
        @Bean
        public RestTemplate restTemplate() {
            return new RestTemplate();
        }
        
        @Autowired
        @LoadBalanced
        private RestTemplate restTemplate;
        
        @GetMapping("call/echo/{message}")
        public String callEcho(@PathVariable String message) {
            // 已经注册的应用的名称
            String serverName = "alibaba-nacos-discovery-server";
            String url = "http://"+ serverName +"/echo/" + message;
            return restTemplate.getForObject(url, String.class);
        }
        
    }
}
