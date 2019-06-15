package com.example.demo;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class NaverOpenApiClientFallbackFactory implements FallbackFactory<NaverOpenApiClient> {

    @Override
    public NaverOpenApiClient create(Throwable cause) {
        return (clientId, clientSecret, query) -> {
            log.error(cause.toString());
            return ResponseNaverBlog.EMPTY;
        };
    }
}
