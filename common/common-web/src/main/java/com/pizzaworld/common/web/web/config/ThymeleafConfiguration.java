package com.pizzaworld.common.web.web.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.extras.conditionalcomments.dialect.ConditionalCommentsDialect;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;
import org.thymeleaf.extras.tiles2.dialect.TilesDialect;
import org.thymeleaf.extras.tiles2.spring4.web.view.ThymeleafTilesView;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;


@Configuration
public class ThymeleafConfiguration {
    @Value("${thymeleaf.cache:false}")
    protected boolean thymeleafCache;

    @Value("${thymeleaf.templateMode:HTML5}")
    protected String thymeleafMode;

    @Value("${thymeleaf.templateSuffix:.html}")
    protected String thymeleafSuffix;

    @Value("${thymeleaf.encoding:UTF-8}")
    protected String thymeleafEncoding;

    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.addTemplateResolver(defaultTemplateResolver());
        templateEngine.addTemplateResolver(classpathTemplateResolver());
        templateEngine.addDialect(new TilesDialect());
        templateEngine.addDialect(new SpringSecurityDialect());
        templateEngine.addDialect(new ConditionalCommentsDialect());
        templateEngine.addDialect(new Java8TimeDialect());
        return templateEngine;
    }

    @Bean
    public ServletContextTemplateResolver defaultTemplateResolver() {
        ServletContextTemplateResolver defaultTemplateResolver = new ServletContextTemplateResolver();
        defaultTemplateResolver.setPrefix("WEB-INF/");
        defaultTemplateResolver.setSuffix(thymeleafSuffix);
        defaultTemplateResolver.setTemplateMode(thymeleafMode);
        defaultTemplateResolver.setCharacterEncoding(thymeleafEncoding);
        defaultTemplateResolver.setOrder(2);
        defaultTemplateResolver.setCacheable(thymeleafCache);
        return defaultTemplateResolver;
    }

    @Bean
    public ThymeleafViewResolver thymeleafTilesViewResolver() {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setViewClass(ThymeleafTilesView.class);
        resolver.setTemplateEngine(templateEngine());
        resolver.setCharacterEncoding(thymeleafEncoding);
        resolver.setCache(thymeleafCache);
        resolver.setOrder(0);
        return resolver;
    }


    @Bean
    public ClassLoaderTemplateResolver classpathTemplateResolver() {
        ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
        resolver.setPrefix("WEB-INF/");
        resolver.setSuffix(thymeleafSuffix);
        resolver.setTemplateMode(thymeleafMode);
        resolver.setCharacterEncoding(thymeleafEncoding);
        resolver.setCacheable(thymeleafCache);
        resolver.setOrder(1);
        return resolver;
    }
}
