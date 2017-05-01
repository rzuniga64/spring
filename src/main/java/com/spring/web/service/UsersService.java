package com.spring.web.service;

import com.spring.web.dao.User;
import com.spring.web.dao.UsersDAO;
import org.springframework.stereotype.Service;

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
@Service("usersService")
public class UsersService {

    /** Offers data access object. */
    private UsersDAO usersDao;

    /**
     *  set the Users data access object.
     *  @param newUsersDao offersDao
     */
    @Resource
    public void setUsersDao(final UsersDAO newUsersDao) {
        this.usersDao = newUsersDao;
    }

    /**
     * Create a user.
     * @param user user
     */
    public void create(final User user) {

        usersDao.create(user);
    }
}
