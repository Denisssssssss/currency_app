package com.example.curency.lib.services;

import com.example.curency.impl.models.CurrencyBody;
import com.example.curency.impl.util.CurrencyParams;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name = "currency-api", url = "${currency.api.url}")
public interface CurrencyClient {

    @GetMapping("/{date}.json")
    CurrencyBody getCurrencyTrend(@SpringQueryMap CurrencyParams currencyParams, @PathVariable("date") String date);
}
