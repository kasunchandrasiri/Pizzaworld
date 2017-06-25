package com.pizzaworld.store.web.web.config;

import com.pizzaworld.common.web.web.config.AbstractJettyConfiguration;
import org.springframework.context.annotation.Configuration;


@Configuration
public class StoreJettyConfiguration extends AbstractJettyConfiguration {

    private static final String WEB_DIRECTORY = "webapp";

    private static final String WEB_DIRECTORY_RELATIVE_PATH = "./";

    @Override
    public String getWebApplicationDirectoryName() {
        return WEB_DIRECTORY;
    }

    @Override
    public String getWebApplicationRelativePath() {
        return WEB_DIRECTORY_RELATIVE_PATH;
    }
}
