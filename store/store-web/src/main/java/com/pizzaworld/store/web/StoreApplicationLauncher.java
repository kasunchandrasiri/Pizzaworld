package com.pizzaworld.store.web;

import com.pizzaworld.store.web.boot.config.StoreApplicationConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class StoreApplicationLauncher {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(StoreApplicationConfiguration.class, args);
    }
}
