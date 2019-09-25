package com.example.demo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "cafe-api", url = "${cafe.api.url}",
        fallbackFactory = CafeClientFallbackFactory.class)
public interface CafeClient {

    @RequestMapping(method = RequestMethod.GET, value = "/api/coffees", produces = "application/json")
    List<String> getCoffees();

    @RequestMapping(method = RequestMethod.GET, value = "/api/juices", produces = "application/json")
    List<String> getJuices();

}