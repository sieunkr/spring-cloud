package com.example.demo;

import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

public class KakaoOpenApiConfiguration {

    @Value("${kakao.openapi.authorization}")
    private String kakaoOpenApiAuthorization;

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate ->
                requestTemplate.header("Authorization", "KakaoAK " + kakaoOpenApiAuthorization);
    }
}
