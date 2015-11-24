package com.jurdox.spring.web.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("offersDao")
public class OffersDao {

	private NamedParameterJdbcTemplate jdbc;

	public OffersDao() {
		System.out.println("Successfully loaded offers DAO");
	}

	@Autowired
	public void setJdbc(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}

	public boolean updateOffer(Offer offer) {
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(offer);
		return jdbc.update("update offers set name=:name, email=:email, text=:text where id=:id", params) == 1;
	}

	public boolean createOffer(Offer offer) {
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(offer);
		return jdbc.update("insert into offers (name, email, text) values(:name, :email, :text)", params) == 1;
	}

	@Transactional
	public int[] createOfferList(List<Offer> offer) {
		SqlParameterSource[] params = SqlParameterSourceUtils.createBatch(offer.toArray());
		return jdbc.batchUpdate("insert into offers (id, name, email, text) values(:id, :name, :email, :text)", params);
	}

	public boolean deletedOffer(int id) {
		MapSqlParameterSource params = new MapSqlParameterSource("id", id);
		return jdbc.update("delete from offers where id = :id", params) == 1;
	}

	public List<Offer> getOffers() {
		return jdbc.query("select * from offers", new RowMapper<Offer>() {

			public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
				Offer offer = new Offer();
				offer.setId(rs.getInt("id"));
				offer.setName(rs.getString("name"));
				offer.setEmail(rs.getString("email"));
				offer.setText(rs.getString("text"));

				return offer;
			}

		});
	}

	public Offer getOffer(int id) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);

		return jdbc.queryForObject("select * from offers where id = :id", params, new RowMapper<Offer>() {

			public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
				Offer offer = new Offer();
				offer.setId(rs.getInt("id"));
				offer.setName(rs.getString("name"));
				offer.setEmail(rs.getString("email"));
				offer.setText(rs.getString("text"));

				return offer;
			}
		});
	}

}
