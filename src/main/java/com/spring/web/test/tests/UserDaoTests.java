package com.spring.web.test.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ActiveProfiles("dev")
@ContextConfiguration(locations = {
        "classpath:WEB-INF/config/dao-context.xml",
        "classpath:WEB-INF/config/security-context.xml",
        "classpath:datasource.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class UserDaoTests {

    @Test
    public void testCreateUser() {

        assertEquals("Dummy test", 1, 1);
    }
}
