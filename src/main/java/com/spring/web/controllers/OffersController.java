package com.spring.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//import javax.servlet.http.HttpSession;

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
     *  @param model model
     *  @return a String
     */
    @RequestMapping("/")
    public String showHome(final Model model) {

        // Model will exist in RequestScope not Session. So the Object is only
        // available during a request.
        model.addAttribute("name", "Cinnamon");

        return "index";
    }

    /*@RequestMapping("/")
    public String showHome(final HttpSession session) {
        session.setAttribute("name", "Boris");
        return "index";
    }*/
}

