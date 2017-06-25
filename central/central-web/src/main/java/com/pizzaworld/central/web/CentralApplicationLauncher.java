package com.pizzaworld.central.web;

import com.pizzaworld.central.web.boot.config.CentralApplicationConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class CentralApplicationLauncher {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(CentralApplicationConfiguration.class, args);
    }
}
