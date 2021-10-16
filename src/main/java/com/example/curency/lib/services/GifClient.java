package com.example.curency.lib.services;

import com.example.curency.impl.util.GiphyParams;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "gif-api", url = "${giphy.api.url}")
public interface GifClient {

    @GetMapping
    String getGif(@SpringQueryMap GiphyParams giphyParams);
}