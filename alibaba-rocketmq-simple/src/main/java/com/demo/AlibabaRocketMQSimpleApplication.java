package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;

/**
 * @author wujiawei
 * @see
 * @since 2021/4/21 下午5:01
 */
@EnableBinding({ Source.class, Sink.class })
@SpringBootApplication
public class AlibabaRocketMQSimpleApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(AlibabaRocketMQSimpleApplication.class, args);
    }
    
}
