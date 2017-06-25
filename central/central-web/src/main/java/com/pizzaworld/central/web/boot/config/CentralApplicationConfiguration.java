package com.pizzaworld.central.web.boot.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.pizzaworld.central","com.pizzaworld.common.web"})
public class CentralApplicationConfiguration {
}
