package com.example.curency;

import com.example.curency.lib.services.CurrencyService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@EnableFeignClients(basePackageClasses = CurrencyService.class)
@PropertySource(value = "classpath:const.properties")
public class CurencyApplication {

    public static void main(String[] args) {
        SpringApplication.run(CurencyApplication.class, args);
    }

}
