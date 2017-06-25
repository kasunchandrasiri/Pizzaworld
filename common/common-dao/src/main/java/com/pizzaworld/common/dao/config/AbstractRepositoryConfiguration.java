package com.pizzaworld.common.dao.config;

import com.pizzaworld.common.dao.audit.SpringSecurityAuditAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.pizzaworld")
@PropertySource(value = "classpath:database.properties")
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public abstract class AbstractRepositoryConfiguration {

    @Bean(name = "dataSource")
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(getDriverName());
        dataSource.setUrl(getDatabaseUrl());
        dataSource.setUsername(getDatabaseUsername());
        dataSource.setPassword(getDatabasePassword());
        return dataSource;
    }


    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setShowSql(getShowSql());
        vendorAdapter.setGenerateDdl(true);
        vendorAdapter.setDatabase(Database.MYSQL);
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan("com.pizzaworld");
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(setAdditionalProperties());

        return em;
    }

    @Bean
    public AuditorAware<String> auditorAware() {
        return new SpringSecurityAuditAware();
    }

    private Properties setAdditionalProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "update");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
        properties.setProperty("hibernate.jdbc.fetch_size", "200");
        properties.setProperty("hibernate.jdbc.batch_size", "50");
        properties.setProperty("hibernate.order_inserts", "true");
        properties.setProperty("hibernate.order_updates", "true");
        properties.setProperty("hibernate.order_updates", "true");
        properties.setProperty("hibernate.id.new_generator_mappings","false");
        return properties;
    }


    protected abstract String getDriverName();
    protected abstract String getDatabaseUrl();
    protected abstract String getDatabaseUsername();
    protected abstract String getDatabasePassword();
    protected abstract boolean getShowSql();
}
