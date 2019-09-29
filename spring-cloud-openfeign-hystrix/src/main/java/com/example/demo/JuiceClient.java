package com.example.demo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "juice-api", url = "${cafe.api.url}",
        fallbackFactory = JuiceClientFallbackFactory.class)
public interface JuiceClient {

    @RequestMapping(method = RequestMethod.GET, value = "/api/juices", produces = "application/json")
    List<String> getJuices();

}