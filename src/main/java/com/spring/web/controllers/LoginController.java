package com.spring.web.controllers;

import com.spring.web.dao.User;
import com.spring.web.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/** LoginController class. */
@Controller
public class LoginController {

    /** Users service. */
    private UsersService usersService;

    /**
     * Set the users service.
     * @param newUsersService newUsersService
     */
    @Autowired
    public void setUsersService(final UsersService newUsersService) {
        this.usersService = newUsersService;
    }

    /**
     * showLogin method.
     * @param model model
     * @return a String
     */
    @RequestMapping("/login")
    public String showLogin(final Model model) {

        model.addAttribute("user", new User());
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
     * showLogout method.
     * @return a String
     */
    @RequestMapping("/logout")
    public String showLoggedOut() {

        return "logout";
    }

    /**
     * createAccount method.
     * @param user the user
     * @param result result
     * @return the user as a String
     */
    @RequestMapping(value = "/createaccount", method = RequestMethod.POST)
    public String createAccount(@Valid final User user,
                                final BindingResult result) {

        if (result.hasErrors()) {
            return "newaccount";
        }

        user.setAuthority("ROLE_USER");
        user.setEnabled(true);

        if (usersService.exists(user.getUsername())) {
            result.rejectValue("username", "DuplicateKey.user.username");
            return "newaccount";
        }

        try {
            usersService.create(user);
        } catch (DuplicateKeyException e) {
            result.rejectValue("username", "DuplicateKey.user.username");
            return "newaccount";
        }

        return "accountcreated";
    }
}
