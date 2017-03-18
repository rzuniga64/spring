package com.spring.web.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.models.Offer;
import com.spring.web.dao.OffersDAO2;

import javax.annotation.Resource;

/**
 *  OffersService class. A class that provides the service of coordinating data
 *  access objects.
 *
 *  @ Service annotation is equivalent to @Component.
 *  We need an XML file to load our service, service-context.xml.
 *  Autowiring our OffersDAO into OffersService. Then autowire OffersService
 *  into OfferController in the OfferController class.
 */
@Service("offersService")
public class OffersService {

    /** Offers data access object. */
    private OffersDAO2 offersDao;

    /**
     *  set the Offers data access object.
     *  @param newOffersDao offersDao
     */
    @Resource
    public void setOffersDao(final OffersDAO2 newOffersDao) {
        this.offersDao = newOffersDao;
    }

    /**
     *  Get the current list of Offers.
     *  @return the current list of Offers.
     */
    public List<Offer> getCurrent() {
        return offersDao.getOffers();
    }

    /**
     * Create an offer.
     * @param offer offer
     */
    public void create(final Offer offer) {

        offersDao.create(offer);
    }
}
