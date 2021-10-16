package com.example.curency.impl.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;

@AllArgsConstructor
@Getter
public class CurrencyBody {

    private String disclaimer;
    private String license;
    private String timestamp;
    private String base;
    private Map<String, Double> rates;
}
