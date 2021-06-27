package com.demo;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wujiawei
 * @see
 * @since 2021/4/21 下午5:14
 */
@Slf4j
@AllArgsConstructor
@RestController
public class EchoController {
    
    private final SenderService senderService;
    
    @GetMapping("echo/{message}")
    public String echo(@PathVariable String message) {
        senderService.send(message);
        return "success";
    }
    
    
}
