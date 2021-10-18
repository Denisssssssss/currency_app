package com.example.curency.lib.services;

public interface CurrencyService {

    boolean trendIsPositive(String base) throws IllegalStateException;
}