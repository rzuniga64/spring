package com.spring.web.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by Owner on 4/25/2017.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * configure method.
     * @param http http
     * @throws Exception Exception
     */
    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/", "/index").permitAll()
                    .antMatchers("/offers").permitAll()
                    .antMatchers("/resources/**").permitAll()
                    .antMatchers("/createoffer").authenticated()
                    .antMatchers("/docreate").authenticated()
                    .antMatchers("offercreated").authenticated()
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                    .loginPage("/login")
                    .failureForwardUrl("/login?error=true")
                    .permitAll()
                    .and()
                .logout()
                    .permitAll();
    }

    /**
     * configureGlobal method.
     * @param auth auth
     * @throws Exception Exception
     */
    @Autowired
    public void configureGlobal(final AuthenticationManagerBuilder auth)
            throws Exception {

        auth
            .inMemoryAuthentication()
            .withUser("rzuniga64").password("aggies92").roles("USER");
    }
}
