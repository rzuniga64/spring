package com.spring.web.dao;

import com.spring.models.Offer;
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
}
