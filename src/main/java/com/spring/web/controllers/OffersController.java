package com.spring.web.controllers;

import com.spring.models.Offer;
import com.spring.web.service.OffersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

//import javax.servlet.http.HttpSession;

/**
 *  OffersController class.
 *  Autowiring our OffersDAO into OffersService.
 */
@Controller
public class OffersController {

    /** Offers service. */
    private OffersService offersService;

    /** Default constructor. */
    public OffersController() { }

    /**
     * Set the Offers service.
     * @param newOffersService newOffersService
     */
    @Resource
    public void setOffersService(final OffersService newOffersService) {

        this.offersService = newOffersService;
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

        List<Offer> offers = offersService.getCurrent();

        // Model will exist in RequestScope not Session. So the Object is only
        // available during a request.
        model.addAttribute("offers", offers);
        // model.addAttribute("name", "Cinnamon");

        return "index";
    }

    /*@RequestMapping("/")
    public String showHome(final HttpSession session) {
        session.setAttribute("name", "Boris");
        return "index";
    }*/
}

