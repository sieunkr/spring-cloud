package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
public class TestController {

    private final CafeClient cafeClient;

    @GetMapping
    public List<String> getAll(){

        List<CompletableFuture<List<String>>> futureList = new ArrayList<>();

        //TODO:쓰레드 풀 설정
        futureList.add(CompletableFuture.supplyAsync(cafeClient::getCoffees));
        futureList.add(CompletableFuture.supplyAsync(cafeClient::getJuices));

        List<String> items =
                futureList.stream()
                        .map(CompletableFuture::join)
                        .flatMap(Collection::stream)
                        .collect(Collectors.toList());

        return items;
    }
}
