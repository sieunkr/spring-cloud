package com.example.demo;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface CafeUseCase {

    CompletableFuture<List<String>> getCoffees();
    CompletableFuture<List<String>> getJuices();
    CompletableFuture<List<String>> getAll();
}