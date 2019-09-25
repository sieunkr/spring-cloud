package com.example.demo;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class CafeClientFallbackFactory implements FallbackFactory<CafeClient> {

    @Override
    public CafeClient create(Throwable cause) {
        return null;
    }
}
