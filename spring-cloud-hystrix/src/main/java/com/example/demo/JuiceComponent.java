package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
@RequiredArgsConstructor
public class JuiceComponent {

    private final RestTemplate juiceRestTemplate;

    public List<String> getJuice(){

        return juiceRestTemplate.exchange("http://localhost:8081/api/juices"
                , HttpMethod.GET,null
                ,new ParameterizedTypeReference<List<String>>() {}).getBody();

    }

}
