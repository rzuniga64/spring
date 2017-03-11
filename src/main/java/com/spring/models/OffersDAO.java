package com.spring.models;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *  OffersDAO class.
 */
@Component("offersDao")
public class OffersDAO {

    /** JDBC template. */
    private JdbcTemplate jdbc;

    /**
     *  Get JDBC connection.
     *  @return JDBC connection
     */
    public JdbcTemplate getJdbc() {
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
    public void setDataSource(final DataSource newJdbc) {
        this.jdbc = new JdbcTemplate(newJdbc);
    }

    /**
     * Get offers.
     * @return offers
     */
    public List<Offer> getOffers() {

        return jdbc.query("select * from offers", new RowMapper<Offer>() {

            public Offer mapRow(final ResultSet resultSet, final int i)
                                throws SQLException {

                Offer offer = new Offer();
                offer.setId(resultSet.getInt("id"));
                offer.setName(resultSet.getString("name"));
                offer.setText(resultSet.getString("text"));
                offer.setEmail(resultSet.getString("email"));

                return offer;
            }
        });
    }
}
