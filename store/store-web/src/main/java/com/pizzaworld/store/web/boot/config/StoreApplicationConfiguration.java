package com.pizzaworld.store.web.boot.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.pizzaworld.store","com.pizzaworld.common.web"})
public class StoreApplicationConfiguration {
}
