package com.spring.web.controllers;

import com.spring.web.dao.User;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/** LoginController class. */
@Controller
public class LoginController {
    /**
     * showLogin method.
     * @return a String
     */
    @RequestMapping("/login")
    public String showLogin() {

        return "login";
    }

    /**
     * showNewAccount method.
     * @param model model
     * @return a String
     */
    @RequestMapping("/newaccount")
    public String showNewAccount(final Model model) {

        model.addAttribute("user", new User());
        return "newaccount";
    }

    /**
     * accountCreated method.
     * @return a String
     */
    @RequestMapping("/createaccount")
    public String createAccount() {

        return "accountcreated";
    }
}
