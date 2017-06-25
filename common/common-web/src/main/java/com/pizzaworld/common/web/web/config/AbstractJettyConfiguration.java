package com.pizzaworld.common.web.web.config;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.ServletContextInitializer;
import org.springframework.boot.context.embedded.jetty.JettyEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;


import javax.servlet.SessionCookieConfig;
import java.io.File;
import java.io.IOException;


public abstract class AbstractJettyConfiguration implements EmbeddedServletContainerCustomizer {

    @Bean
    public ServletContextInitializer initializer() {
        return servletContext -> {
            SessionCookieConfig configuration = servletContext.getSessionCookieConfig();
            configuration.setName(getCookieName());
        };
    }

    protected String getCookieName() {
        return "JSESSSIONID";
    }

    @Override
    public void customize(ConfigurableEmbeddedServletContainer configurableEmbeddedServletContainer) {
        try {
            final JettyEmbeddedServletContainerFactory containerFactory = (JettyEmbeddedServletContainerFactory)
                    configurableEmbeddedServletContainer;
            containerFactory.setDocumentRoot(calculateWebApplicationRoot());

            if (!containerFactory.getDocumentRoot().exists()) {
                throw new RuntimeException("Unable to resolve web application root directory - check 'webapp' exists!");
            }
        } catch (IOException ex) {
        }
    }

    private File calculateWebApplicationRoot() throws IOException {
        final ClassPathResource resource = new ClassPathResource(getWebApplicationDirectoryName());
        if (resource.exists()) {
            return resource.getFile();
        }
        return new File(getWebApplicationRelativePath());
    }


    public abstract String getWebApplicationDirectoryName();
    public abstract String getWebApplicationRelativePath();
}
