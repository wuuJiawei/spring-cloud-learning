package com.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wujiawei
 * @see
 * @since 2021/4/12 下午8:58
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class AlibabaNacosDiscoveryClientFeignApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(AlibabaNacosDiscoveryClientFeignApplication.class, args);
    }
    
    @FeignClient("alibaba-nacos-discovery-server")
    interface EchoService{
    
        @GetMapping("/echo/{message}")
        String echo(@PathVariable("message") String message);
        
    }
    
    @Slf4j
    @RestController
    static class OpenFeignController {
    
        @Autowired
        private EchoService echoService;
    
        @GetMapping("feign/echo/{message}")
        public String feignEcho(@PathVariable String message) {
            return echoService.echo(message);
        }
        
    }
    
}
