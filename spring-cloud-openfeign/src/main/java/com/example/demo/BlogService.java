package com.example.demo;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@Service
@Configuration
@EnableConfigurationProperties({ NaverOpenApiProperties.class })
public class BlogService {

    private final NaverOpenApiProperties naverOpenApiProperties;
    private final NaverOpenApiClient naverOpenApiClient;

    public BlogService(NaverOpenApiProperties naverOpenApiProperties, NaverOpenApiClient naverOpenApiClient) {
        this.naverOpenApiProperties = naverOpenApiProperties;
        this.naverOpenApiClient = naverOpenApiClient;
    }

    public ResponseNaverBlog findBlogByQuery(String query){
        return naverOpenApiClient.findBlogByQuery(naverOpenApiProperties.getClientId(), naverOpenApiProperties.getClientSecret(), query);
    }

}
