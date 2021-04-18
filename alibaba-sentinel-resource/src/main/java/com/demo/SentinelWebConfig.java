package com.demo;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @author wujiawei
 * @see
 * @since 2021/4/16 上午9:13
 */
@Configuration
public class SentinelWebConfig {
    
    @Bean
    public BlockExceptionHandler sentinelBlockExceptionHandler() {
        return new BlockExceptionHandler() {
            @Override
            public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                    BlockException e) throws Exception {
                // 429 Too Many Requests
                httpServletResponse.setStatus(429);
    
                PrintWriter out = httpServletResponse.getWriter();
                out.println("Oops, blocked by Sentinel: " + e.getClass().getSimpleName());
                out.flush();
                out.close();
            }
        };
    }
    
}
