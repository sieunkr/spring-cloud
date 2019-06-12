package com.example.demo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "post-api", url = "${naver.openapi.url}", fallback = NaverOpenApiClientFallback.class)
public interface NaverOpenApiClient {

    @RequestMapping(method = RequestMethod.GET, value = "/v1/search/blog.jn", produces = "application/json")
    ResponseNaverBlog findBlogByQuery(@RequestHeader("X-Naver-Client-Id") String clientId,
                                @RequestHeader("X-Naver-Client-Secret") String clientSecret,
                                @RequestParam(name = "query") String query);
}