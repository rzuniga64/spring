package com.spring.web.test.tests;

import static org.junit.Assert.*;

import com.spring.models.User;
import com.spring.web.dao.UsersDAO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.util.List;

@ActiveProfiles("dev")
@ContextConfiguration(locations = {
        "classpath:dao-context.xml",
        "classpath:security-context.xml",
        "classpath:datasource.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class UserDaoTests {

    @Autowired
    private UsersDAO usersDao;

    @Autowired
    private DataSource dataSource;

    @Before
    public void init() {
        JdbcTemplate jdbc = new JdbcTemplate(dataSource);

        jdbc.execute("delete from users");
        jdbc.execute("delete from authorities");
    }

    @Test
    public void testCreateUser() {
        User user = new User("johnwpurcell", "hellothere", "john@caveofprogramming.com", true, "user");

        assertTrue("User creation should return true", usersDao.create(user));

        List<User> users = usersDao.getAllUsers();

        assertEquals("Number of users should be 1.", 1, users.size());

        assertTrue("User should exist.", usersDao.exists(user.getUsername()));

        //assertEquals("Created user should be identical to retrieved user", user, users.get(0));
    }
}
