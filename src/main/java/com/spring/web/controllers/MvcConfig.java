package com.spring.web.controllers;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


/**
 * MvcConfig class.
 */
@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

    /**
     * addViewControllers method.
     * @param registry registry
     */
    @Override
    public void addViewControllers(final ViewControllerRegistry registry) {

        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/createoffer").
                setViewName("createoffer");
        registry.addViewController("/docreate").setViewName("docreate");
        registry.addViewController("/offercreasted")
                .setViewName("offercreated");
        registry.addViewController("/resources/**");
        registry.addViewController("/offers").setViewName("offers");
        registry.addViewController("/login").setViewName("login");
    }
}
