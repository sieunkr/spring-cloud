package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CafeUseCaseImpl implements CafeUseCase {

    private final CafeClient cafeClient;
    private final ThreadPoolTaskExecutor threadPoolTaskExecutor;

    public CompletableFuture<List<String>> getCoffees(){
        return CompletableFuture.supplyAsync(cafeClient::getCoffees, threadPoolTaskExecutor);
    }

    public CompletableFuture<List<String>> getJuices(){
        return CompletableFuture.supplyAsync(cafeClient::getJuices, threadPoolTaskExecutor);
    }

    public CompletableFuture<List<String>> getAll(){
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
                );
    }

}
