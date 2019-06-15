package com.example.demo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "test-b")
public interface ApiClient {

    @RequestMapping(method = RequestMethod.GET, value = "/api/test")
    String home();

}
