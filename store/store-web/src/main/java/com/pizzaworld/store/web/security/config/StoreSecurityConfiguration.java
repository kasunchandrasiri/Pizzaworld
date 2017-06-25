package com.pizzaworld.store.web.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;


@Configuration
@EnableWebSecurity
public class StoreSecurityConfiguration extends WebSecurityConfigurerAdapter {



    public String[] getPublicUrls() {
        return new String[0];
    }


    public String[] getAdministrationUrls() {
        return new String[]{"/", "/administrator/**"};
    }


    public String getDefaultSuccessUrl() {
        return "/home";
    }

    @Autowired
    DataSource dataSource;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/login", "/resources/**", "/resources/resources/**").permitAll()
                .antMatchers(getPublicUrls()).permitAll()
                .antMatchers(getAdministrationUrls()).access("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER') or hasRole('ROLE_STAFF') or hasRole('ROLE_CUSTOMER')")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .usernameParameter("username")
                .passwordParameter("password")
                .loginPage("/login")
                .defaultSuccessUrl(getDefaultSuccessUrl())
                .failureUrl("/login?error=true")
                .permitAll()
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/administrator/logout"))
                .logoutSuccessUrl("/login").permitAll()
                .and().csrf().disable();

    }

/*    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/api*//**");
     }*/

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
                .passwordEncoder(passwordEncoder())
                .usersByUsernameQuery("select username, password , 1 as enabled from store_user where username=?")
                .authoritiesByUsernameQuery("select u.username, r.role from store_role r, store_user u, user_role ur where u.id= ur.user_id and r.id = ur.role_id and u.username = ? ");
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder;
    }

}
