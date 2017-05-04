package com.spring.web.dao;

import com.spring.models.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.*;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Users data access object.
 */
@Component("usersDao")
public class UsersDAO {

    /** JDBC template. */
    private NamedParameterJdbcTemplate jdbc;

    /** Constructor. */
    public UsersDAO() { }

    /**
     *  Get JDBC connection.
     *  @return JDBC connection
     */
    public NamedParameterJdbcTemplate getJdbc() {
        return jdbc;
    }

    /**
     *  Set JDBC connection.
     *  Pass a DataSource instead of a JdbcTemplate to get access to some great
     *  methods from DataSource which comes from org.apache.commons.dbcp.
     *  BasicDataSource.
     *  @param newJdbc newJdbc
     */
    @Resource
    public void setNamedParameterJdbcTemplate(final DataSource newJdbc) {
        this.jdbc = new NamedParameterJdbcTemplate(newJdbc);
    }

    /**
     *  Create a User object in the database.
     *  Create a set of parameters you can use to replace placeholders in your
     *  SQL from your actual bean properties.
     *
     * @param user user
     * @return true if an Offer object is returned; false otherwise
     */
    @Transactional
    public boolean create(final User user) {

        BeanPropertySqlParameterSource params =
                new BeanPropertySqlParameterSource(user);

        jdbc.update("insert into springtutorial.users (username, password, email, enabled) "
                + "values(:username, :password, :email, :enabled)", params);

        return jdbc.update("insert into springtutorial.authorities (username, authority) "
                + "values(:username, :authority)", params) == 1;
    }

    /**
     * Username exists?
     * @param username username
     * @return true if exists; false otherwise
     */
    public boolean exists(final String username) {
        return jdbc.queryForObject("select count(*) from users where username=:username",
                new MapSqlParameterSource("username", username), Integer.class) > 0;

    }

    /**
     * Take the SQL result and gives a RowMapper that maps each row to a User
     * bean.
     * @return all users
     */
    public List<User> getAllUsers() {

        return jdbc.query("select * from springtutorial.users, "
                        + "springtutorial.authorities "
                        + "where users.username=authorities.username",
                new BeanPropertyRowMapper<User>(User.class));
    }

    /**
     *  Get all users. Alternative method to getAllUsers (not used).
     *  @return offers
     */
    public List<User> getUsers() {

        return jdbc.query("select * from springtutorial.users, "
                + "springtutorial.authorities where users.username=authorities.username",
                new RowMapper<User>() {

            public com.spring.models.User mapRow(final ResultSet resultSet, final int i)
                    throws SQLException {

                User user = new com.spring.models.User();
                user.setUsername(resultSet.getString("username"));
                user.setEmail(resultSet.getString("email"));
                user.setAuthority(resultSet.getString("authority"));
                user.setEnabled(resultSet.getBoolean("enabled"));

                return user;
            }
        });
    }
}
