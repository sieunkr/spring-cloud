package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class NaverOpenApiClientFallback implements NaverOpenApiClient {

    @Override
    public ResponseNaverBlog findBlogByQuery(String clientId, String clientSecret, String query) {
        return ResponseNaverBlog.EMPTY;
    }
}
