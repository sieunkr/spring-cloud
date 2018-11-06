package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@RefreshScope
public class CoffeeProvider implements CoffeeUseCase {

    @Value("${coffee.order.max-threads}")
    private long coffeeOrderMaxThreads;

    @Override
    public String order() {
        return "한번에 주문할 수 있는 커피의 최대 갯수는 " + coffeeOrderMaxThreads + "개 입니다.";
    }
}
