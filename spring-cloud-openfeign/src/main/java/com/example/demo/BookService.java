package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final KakaoOpenApiClient kakaoOpenApiClient;

    public BookService(KakaoOpenApiClient kakaoOpenApiClient) {
        this.kakaoOpenApiClient = kakaoOpenApiClient;
    }

    public ResponseKakaoBook findBookByQuery(String query){
        return kakaoOpenApiClient.findBookByQuery(query);
    }


}
