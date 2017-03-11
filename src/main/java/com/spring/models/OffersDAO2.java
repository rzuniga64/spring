package com.spring.models;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
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
public class OffersDAO2 {

    /** JDBC template. */
    private NamedParameterJdbcTemplate jdbc;

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
    public void setDataSource(final DataSource newJdbc) {
        this.jdbc = new NamedParameterJdbcTemplate(newJdbc);
    }

    /**
     *  Get offer.
     *  @param id id
     *  @return offer
     */
    public Offer getOffer(final int id) {

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", 2);

        return jdbc.queryForObject("select * from offers where id = :id",
                params, new RowMapper<Offer>() {

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

    /**
     *  Get offers.
     *  @return offers
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

    /**
     * Delete a row based on id.
     * @param id id
     * @return true if row is deleted; false otherwise.
     */
    public boolean delete(final int id) {

        MapSqlParameterSource params = new MapSqlParameterSource("id", id);

        return jdbc.update("delete from offers where id =:id", params) == 1;
    }
}
