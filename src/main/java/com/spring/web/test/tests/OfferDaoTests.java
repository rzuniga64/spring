package com.spring.web.test.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.models.Offer;
import com.spring.web.dao.OffersDAO2;

import java.util.List;

@ActiveProfiles("dev")
@ContextConfiguration(locations = {
		"classpath:dao-context.xml",
		"classpath:security-context.xml",
		"classpath:datasource.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class OfferDaoTests {
	
	@Autowired
	private OffersDAO2 offersDao;
	
	@Autowired
	private DataSource dataSource;

	@Before
	public void init() {
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		
		jdbc.execute("delete from offers");
		jdbc.execute("delete from users");
		jdbc.execute("delete from authorities");
	}
	
	@Test
	public void testCreateUser() {

        Offer offer = new Offer("johnwpurcell", "john@caveofprogramming.com", "This is a test offer.");

        assertTrue("Offer creation should return true", offersDao.create(offer));

        List<Offer> offers = offersDao.getOffers();

        assertEquals("Should be one offer in database.", 1, offers.size());

        //assertEquals("Retrieved offer should match created offer.", offer, offers.get(0));

        // Get the offer with ID filled in.
        offer = offers.get(0);

        offer.setText("Updated offer text.");
        assertTrue("Offer update should return true", offersDao.update(offer));

        Offer updated = offersDao.getOffer(offer.getId());

        assertEquals("Updated offer should match retrieved updated offer", offer, updated);

        offersDao.delete(offer.getId());

        List<Offer> empty = offersDao.getOffers();

       // assertEquals("Offers lists should be empty.", 0, empty.size());
	}
	
}
