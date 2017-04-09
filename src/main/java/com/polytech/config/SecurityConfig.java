package com.polytech.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

/**
 * Created by E.Marouane on 17/03/2017.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/signup.html").permitAll()
                .antMatchers("/signup").permitAll()
                .antMatchers("/dosignup").permitAll()
                .antMatchers("/login").permitAll()
                .anyRequest()
                .authenticated().and()
                .formLogin().loginPage("/login").and().logout().and().csrf().disable();
    }

    @Autowired
    protected void configure(AuthenticationManagerBuilder auth, DataSource dataSource) throws Exception {
        //auth.inMemoryAuthentication().withUser("marouane").password("12345678").roles("USER");
        System.out.println("AUTH");
        //auth.jdbcAuthentication().dataSource(datasource).passwordEncoder(passwordEncoder);
        //auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
        //auth.inMemoryAuthentication().withUser("marouane").password("123").roles("USER");
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("SELECT username as principal, password as credentials, true FROM users WHERE username = ?");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
