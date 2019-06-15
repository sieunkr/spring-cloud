package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HomeController {

    private final ApiClient apiClient;

    public HomeController(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    @GetMapping("/my")
    public String home(){
        return apiClient.home();
    }
}
