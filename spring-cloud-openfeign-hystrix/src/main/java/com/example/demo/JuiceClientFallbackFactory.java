package com.example.demo;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class JuiceClientFallbackFactory implements FallbackFactory<JuiceClient> {

    @Override
    public JuiceClient create(Throwable cause) {
        log.info("log:" + cause.getMessage());
        return null;
    }
}