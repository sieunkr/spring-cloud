package com.example.demo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
public class TestController {

    private final CafeClient cafeClient;
    private final ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @GetMapping
    public List<String> getAll(){

        log.info(Thread.currentThread().getName());

        /*
        List<CompletableFuture<List<String>>> futureList = new ArrayList<>();

        //TODO:쓰레드 풀 설정
        futureList.add(CompletableFuture.supplyAsync(cafeClient::getCoffees));
        futureList.add(CompletableFuture.supplyAsync(cafeClient::getJuices));

        List<String> items =
                futureList.stream()
                        .map(CompletableFuture::join)
                        .flatMap(Collection::stream)
                        .collect(Collectors.toList());

        */

        CompletableFuture futureByCoffee = CompletableFuture.supplyAsync(cafeClient::getCoffees, threadPoolTaskExecutor);
        CompletableFuture futureByJuice = CompletableFuture.supplyAsync(cafeClient::getJuices, threadPoolTaskExecutor);

        List<CompletableFuture<List<String>>> futureList =
                Arrays.asList(futureByCoffee, futureByJuice);

        return CompletableFuture.allOf(futureByCoffee, futureByJuice)
                .thenApply(Void -> futureList.stream()
                        .map(CompletableFuture::join)
                        .flatMap(Collection::stream)
                        .collect(Collectors.toList())
                ).join();

    }
}