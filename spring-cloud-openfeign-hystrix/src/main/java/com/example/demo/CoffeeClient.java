package com.example.demo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "coffee-api", url = "${cafe.api.url}",
        fallbackFactory = CoffeeClientFallbackFactory.class)
public interface CoffeeClient {

    @RequestMapping(method = RequestMethod.GET, value = "/api/coffees", produces = "application/json")
    List<String> getCoffees();

}