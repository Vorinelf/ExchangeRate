package com.vorinelf.exchange;

import com.vorinelf.exchange.service.ExchangeService;

import java.io.IOException;

public class BestExchange {

    public static void main(String[] args) throws IOException {
        ExchangeService exchangeService = new ExchangeService();
        System.out.println(exchangeService.getAndCheckRegion("Витебская"));
        System.out.println(exchangeService.getAndCheckCity("Лиозно"));


    }


}
