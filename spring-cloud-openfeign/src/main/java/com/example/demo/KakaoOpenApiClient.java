package com.example.demo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "kakao-open-api", url = "${kakao.openapi.url}",
        configuration = KakaoOpenApiConfiguration.class)
public interface KakaoOpenApiClient {

    @RequestMapping(method = RequestMethod.GET,
            value = "/v3/search/book",
            produces = "application/json")
    ResponseKakaoBook findBookByQuery(@RequestParam(name = "query") String query);

}
