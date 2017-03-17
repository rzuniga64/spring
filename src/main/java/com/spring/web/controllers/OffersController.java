package com.spring.web.controllers;

import com.spring.models.Offer;
import com.spring.web.service.OffersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

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
    @RequestMapping("/offers")
    public String showOffers(final Model model) {

        List<Offer> offers = offersService.getCurrent();

        // Model will exist in RequestScope not Session. So the Object is only
        // available during a request.
        model.addAttribute("offers", offers);
        // model.addAttribute("name", "Cinnamon");

        return "offers";
    }

    /**
     *  showTest method.
     *  @param model model
     *  @param id id
     *  @return a String
     */
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String showTest(final Model model, @RequestParam("id") final String id) {

        System.out.println("Id is: " + id);
        return "index";
    }

    /**
     *  createOffer method.
     *  @return the offers page as a String
     */
    @RequestMapping("/createoffer")
    public String createOffer() {

        return "createoffer";
    }

    /**
     * doCreate method.
     * @param model the model
     * @param offer the offer
     * @return the web page as a String
     */
    @RequestMapping(value = "/docreate", method = RequestMethod.POST)
    public String doCreate(final Model model, Offer offer) {

        return "offercreated";
    }

    /*@RequestMapping("/")
    public String showHome(final HttpSession session) {
        session.setAttribute("name", "Boris");
        return "index";
    }*/
}

