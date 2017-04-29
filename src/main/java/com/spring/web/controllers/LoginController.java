package com.spring.web.controllers;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/** LoginController class. */
@Controller
public class LoginController {
    /**
     * showLogin method.
     * @param model model
     * @return a String
     */
    @RequestMapping("/login")
    public String showLogin(final Model model) {

        model.addAttribute("login");
        return "login";
    }
}
