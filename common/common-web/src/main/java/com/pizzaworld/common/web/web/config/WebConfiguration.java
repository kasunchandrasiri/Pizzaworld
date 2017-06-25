package com.pizzaworld.common.web.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.thymeleaf.extras.tiles2.spring4.web.configurer.ThymeleafTilesConfigurer;

import java.util.Locale;

@Configuration
public class WebConfiguration  extends WebMvcConfigurerAdapter {

        @Override
        public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
            configurer.enable();
        }

        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
            registry.addResourceHandler("/resources/**")
                    .addResourceLocations("classpath:/resources/");
            registry.addResourceHandler("/css/**").addResourceLocations("classpath:/resources/css/");
            registry.addResourceHandler("/js/**").addResourceLocations("classpath:/resources/js");
            registry.addResourceHandler("/fonts/**").addResourceLocations("classpath:/resources/fonts/");
            registry.addResourceHandler("/img/**").addResourceLocations("classpath:/resources/img/");
        }



        @Bean
        public ThymeleafTilesConfigurer tilesConfigurer() {
            ThymeleafTilesConfigurer configurer = new ThymeleafTilesConfigurer();
            configurer.setDefinitions("classpath:/WEB-INF/views.xml","classpath:/WEB-INF/views/layouts/views.xml"  );
            return configurer;
        }


        @Override
        public void addViewControllers(ViewControllerRegistry registry) {
            registry.addViewController("/login").setViewName("login");
            registry.addViewController("/").setViewName("home");
            registry.addViewController("/home").setViewName("home");
        }

    }
