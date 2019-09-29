package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CoffeeComponent {

    private final RestTemplate coffeeRestTemplate;

    public List<String> getCoffee(){

        return coffeeRestTemplate.exchange("http://localhost:8081/api/coffees"
                , HttpMethod.GET,null
                ,new ParameterizedTypeReference<List<String>>() {}).getBody();

    }

}
