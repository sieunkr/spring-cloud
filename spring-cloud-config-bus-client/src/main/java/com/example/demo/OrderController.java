package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    CoffeeUseCase coffeeUseCase;

    @GetMapping("/coffee")
    @ResponseStatus(HttpStatus.OK)
    public String Order(){

        //테스트
        return coffeeUseCase.order();
    }

}
