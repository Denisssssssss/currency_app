package com.example.curency.impl.services;

import com.example.curency.impl.models.CurrencyBody;
import com.example.curency.impl.util.CurrencyParams;
import com.example.curency.impl.util.GiphyParams;
import com.example.curency.lib.services.CurrencyClient;
import com.example.curency.lib.services.CurrencyService;
import com.example.curency.lib.services.GifClient;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CurrencyServiceImpl implements CurrencyService {

    private final CurrencyClient currencyClient;

    @Value("${currency.api.key}")
    private String currencyKey;

    @Override
    public boolean trendIsPositive(String base) {

        base = base.toUpperCase();
        LocalDateTime today = LocalDateTime.now();
        LocalDateTime yesterday = today.minusDays(1);

        Double todayTrend = currencyClient.getCurrencyTrend(new CurrencyParams(currencyKey), today.toString()
                        .split("T")[0])
                        .getRates()
                        .get(base);

        Double yesterdayTrend = currencyClient.getCurrencyTrend(new CurrencyParams(currencyKey), yesterday.toString()
                        .split("T")[0])
                        .getRates()
                        .get(base);

        return todayTrend > yesterdayTrend;
    }
}
