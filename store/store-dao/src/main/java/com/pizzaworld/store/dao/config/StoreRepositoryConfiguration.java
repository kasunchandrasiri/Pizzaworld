package com.pizzaworld.store.dao.config;

import com.pizzaworld.common.dao.config.AbstractRepositoryConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement
@ComponentScan("com.pizzaworld.store")
@EnableJpaRepositories(basePackages = "com.pizzaworld.store.dao.repository")
@EntityScan(basePackages = "com.pizzaworld.store.dao.model")
public class StoreRepositoryConfiguration extends AbstractRepositoryConfiguration {

    @Value(value = "${db.url}")
    private String dbUrl;

    @Value(value = "${db.driver}")
    private String dbDriver;

    @Value(value = "${db.username}")
    private String dbUsername;

    @Value(value = "${db.password}")
    private String dbPassword;

    @Value(value = "${db.showSql}")
    private String dbShowSql;


    @Override
    protected String getDriverName() {
        return dbDriver;
    }

    @Override
    protected String getDatabaseUrl() {
        return dbUrl;
    }

    @Override
    protected String getDatabaseUsername() {
        return dbUsername;
    }

    @Override
    protected String getDatabasePassword() {
        return dbPassword;
    }

    @Override
    protected boolean getShowSql() {
        return Boolean.valueOf(dbShowSql);
    }
}
