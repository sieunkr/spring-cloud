package com.example.demo;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class CoffeeComponent {

    private final RestTemplate coffeeRestTemplate;

    @HystrixCommand(fallbackMethod = "getCoffeeFallback")
    public List<String> getCoffee(){

        return coffeeRestTemplate.exchange("http://localhost:8081/api/coffees"
                , HttpMethod.GET,null
                ,new ParameterizedTypeReference<List<String>>() {}).getBody();

    }

    /*
    public List<String> getCoffeeFallback() {
        return Collections.emptyList();
    }
    */

    public List<String> getCoffeeFallback(Throwable e) {

        log.info(e.toString());

        //TODO:FallBack 처리 비즈니스 로직
        return Collections.emptyList();
    }

}