package com.demo;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author wujiawei
 * @see
 * @since 2021/4/16 上午8:40
 */
@Slf4j
@AllArgsConstructor
@RestController
public class EchoController {
    
    
    private final EchoService echoService;
    
    @GetMapping("echo")
    public String echo() {
        String str = echoService.echo("echo: " + new Date());
        log.info(str);
        return str;
    }
    
    @GetMapping("echo2")
    public String echo2() {
        String str = echoService.echo2("echo: " + new Date());
        log.info(str);
        return str;
    }
    
}
