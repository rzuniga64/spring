package com.spring.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.apache.log4j.Logger;

/**
 *  HomeController class.
 */
@Controller
public class HomeController {

    private static Logger logger = Logger.getLogger(HomeController.class);
    /**
     * Display the home page.
     * @return the home page as a String
     */
    @RequestMapping("/")
    public String showHome() {

        logger.debug("Showing home page...");
        logger.info("informational message");
        logger.warn("Warning Message");

        return "index";
    }
}
