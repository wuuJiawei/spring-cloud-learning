package com.demo;

import lombok.AllArgsConstructor;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

/**
 * @author wujiawei
 * @see
 * @since 2021/4/21 下午9:43
 */
@AllArgsConstructor
@Service
public class SenderService {

    private final Source source;
    
    public void send(String message) {
        source.output().send(MessageBuilder.withPayload(message).build());
    }

}
