package com.example.demo;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
@Configuration
@EnableConfigurationProperties({ NaverOpenApiProperties.class })
public class BlogService {

    private final NaverOpenApiProperties naverOpenApiProperties;
    private final NaverOpenApiClient naverOpenApiClient;

    public BlogService(NaverOpenApiProperties naverOpenApiProperties,
                       NaverOpenApiClient naverOpenApiClient) {
        this.naverOpenApiProperties = naverOpenApiProperties;
        this.naverOpenApiClient = naverOpenApiClient;
    }

    public ResponseNaverBlog findBlogByQuery(String query){
        return naverOpenApiClient.findBlogByQuery(naverOpenApiProperties.getClientId(),
                                                  naverOpenApiProperties.getClientSecret(),
                                                  query);
    }

    @Deprecated
    public ResponseNaverBlog legacyFindBlogByQuery(String query){

        final String uri = "https://openapi.naver.com/v1/search/blog.json?query=" + query;

        //TODO:Bean 주입
        RestTemplate restTemplate = new RestTemplate();

        MultiValueMap<String, String> headerMap = new LinkedMultiValueMap<>();
        headerMap.add("X-Naver-Client-Id", naverOpenApiProperties.getClientId());
        headerMap.add("X-Naver-Client-Secret", naverOpenApiProperties.getClientSecret());
        headerMap.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<?> headers = new HttpEntity<>(headerMap);

        ResponseEntity<ResponseNaverBlog> responseEntity =
                restTemplate.exchange(uri, HttpMethod.GET, headers, ResponseNaverBlog.class);

        return responseEntity.getBody();
    }




}
