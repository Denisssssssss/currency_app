package com.example.curency.impl.controllers;

import com.example.curency.impl.models.GifBody;
import com.example.curency.lib.services.GifService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/currency")
public class CurrencyController {

    private final GifService gifService;

    @GetMapping("/{base}")
    public ResponseEntity<GifBody> getTrend(@PathVariable("base") String base) {
        return ResponseEntity.ok(new GifBody(gifService.getGifByTrend(base)));
    }

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<String> handleException(IllegalStateException e) {
        return ResponseEntity
                .badRequest()
                .body(e.getMessage());
    }
}
