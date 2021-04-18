package com.demo;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author wujiawei
 * @see
 * @since 2021/4/16 上午8:38
 */
@Slf4j
@Service
public class EchoService {
    
    @SentinelResource(value = "EchoService#echo", blockHandler = "echoBlockHandler")
    public String echo(String str) {
        return str;
    }
    
    public String echoBlockHandler(String str, BlockException ex) {
        log.error("echoBlockHandler: " + ex.getRuleLimitApp());
        return "block: " + str;
    }
    
    @SentinelResource(value = "EchoService#echo2", defaultFallback = "echoFallback")
    public String echo2(String str) {
        throw new RuntimeException("echo2 抛出异常");
    }
    
    public String echoFallback(Throwable t) {
        String message;
        if (BlockException.isBlockException(t)) {
            message = "Blocked by Sentinel: " + t.getClass().getSimpleName();
        } else {
            message = "Oops, failed: " + t.getClass().getCanonicalName();
        }
        
        log.info(message);
        return message;
    }
    
}
