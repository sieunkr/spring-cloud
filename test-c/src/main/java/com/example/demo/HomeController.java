package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class HomeController {

    @GetMapping("/coffees")
    public List<String> getCoffees(){

        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return Arrays.asList("latte", "mocha");
    }

    @GetMapping("/juices")
    public List<String> getJuices(){
        return Arrays.asList("orange");
    }
}