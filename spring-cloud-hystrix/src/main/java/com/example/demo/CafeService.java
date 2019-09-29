package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CafeService {

    private final CoffeeComponent coffeeComponent;
    private final JuiceComponent juiceComponent;

    public List<String> getCoffee(){
        return coffeeComponent.getCoffee();
    }

    public List<String> getJuice(){
        return juiceComponent.getJuice();
    }

    public List<String> getAll(){
        return Collections.emptyList();
    }

}
