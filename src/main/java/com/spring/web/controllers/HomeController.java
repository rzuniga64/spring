package com.spring.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *  HomeController class.
 */
@Controller
public class HomeController {

    /**
     * Display the home page.
     * @return the home page as a String
     */
    @RequestMapping("/")
    public String showHome() {
        return "index";
    }
}
