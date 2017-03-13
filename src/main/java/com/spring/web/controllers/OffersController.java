package com.spring.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *  OffersController class.
 */
@Controller
public class OffersController {

    /** Default constructor. */
    public OffersController() {
        System.out.println("Controller");
    }
    /**
     *  showHome method.
     * '/' means if we go to the root of our application then it will be
     *  capable of handling it.
     *  @return a String
     */
    @RequestMapping("/")
    public String showHome() {
        return "index";
    }
}

