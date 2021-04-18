package com.demo;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @author wujiawei
 * @see
 * @since 2021/4/16 上午10:29
 */
//@Component
public class BaseBlockExceptionHandler implements BlockExceptionHandler {
    
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, BlockException e)
            throws Exception {
        // 429 Too Many Requests
        httpServletResponse.setStatus(429);
    
        PrintWriter out = httpServletResponse.getWriter();
        out.println("Oops, blocked by Sentinel: " + e.getClass().getSimpleName());
        out.flush();
        out.close();
    }
}
