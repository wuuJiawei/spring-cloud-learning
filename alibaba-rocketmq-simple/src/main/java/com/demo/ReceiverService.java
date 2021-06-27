package com.demo;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Service;

/**
 * @author wujiawei
 * @see
 * @since 2021/4/21 下午9:47
 */
@Service
public class ReceiverService {
    
    @StreamListener(Sink.INPUT)
    public void receiveInput1(String message) {
        System.out.println("input1 receive: " + message);
    }
    
}
