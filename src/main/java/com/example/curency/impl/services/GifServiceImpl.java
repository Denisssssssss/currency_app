package com.example.curency.impl.services;

import com.example.curency.impl.util.GiphyParams;
import com.example.curency.lib.services.CurrencyService;
import com.example.curency.lib.services.GifClient;
import com.example.curency.lib.services.GifService;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class GifServiceImpl implements GifService {

    private final GifClient gifClient;
    private final CurrencyService currencyService;

    @Value("${giphy.api.search.positive}")
    private String positive;

    @Value("${giphy.api.search.negative}")
    private String negative;

    @Value("${giphy.api.key}")
    private String key;

    @Value("${giphy.api.search.limit}")
    private Integer limit;

    @Override
    public String getGifByTrend(String base) {

        String json;

        if (currencyService.trendIsPositive(base)) {
            json = gifClient.getGif(new GiphyParams(key, positive, limit, (int) (Math.random() * 25)));
        } else {
            json = gifClient.getGif(new GiphyParams(key, negative, limit, (int) (Math.random() * 25)));
        }

        JSONObject response = new JSONObject(json);
        //limit = 1 -> 1 object array

        return response.getJSONArray("data")
                .getJSONObject(0)
                .getJSONObject("images")
                .getJSONObject("original")
                .getString("url");
    }
}
