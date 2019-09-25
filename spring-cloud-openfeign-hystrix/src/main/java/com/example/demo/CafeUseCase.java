package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CafeUseCase {

    private final CafeClient cafeClient;

    public List<String> getCoffees(){
        return cafeClient.getCoffees();
    }

    public List<String> getJuices(){
        return cafeClient.getJuices();
    }

}
