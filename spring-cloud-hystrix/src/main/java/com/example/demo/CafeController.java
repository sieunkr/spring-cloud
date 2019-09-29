package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/test")
public class CafeController {

    private final CafeService cafeService;

    @GetMapping("/nomal")
    public List<String> getJuiceAll(){
        return cafeService.getJuice();
    }

    @GetMapping("/delay")
    public List<String> getCoffeeAll(){
        return cafeService.getCoffee();
    }

}
