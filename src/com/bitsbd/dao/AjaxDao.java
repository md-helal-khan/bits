package com.bitsbd.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import com.bitsbd.model.Upazila;

@Component("ajaxDao")
public class AjaxDao {
	
	private NamedParameterJdbcTemplate jdbc;

	@Autowired
	public void setDataSource(DataSource jdbc) {
		try {
			this.jdbc = new NamedParameterJdbcTemplate(jdbc);
		} catch (CannotGetJdbcConnectionException e) {
			System.out.println("Please check jdbc!");
		}
		
	}
	
	public List<Upazila> getUpazilaByDistrictId(int DistrictId) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("DistrictId", DistrictId);
		// return jdbc.queryForObject("Select * from notices where id = :id", params, new RowMapper<Notice>() {
		return jdbc.query("SELECT * FROM Upazila where DistrictId = :DistrictId ", params, new RowMapper<Upazila>() {
			public Upazila mapRow(ResultSet rs, int rowNum) throws SQLException {
				Upazila upazila = new Upazila();
				upazila.setUpazilaId(rs.getInt("UpazilaId"));
				upazila.setNameBan(rs.getString("NameBan"));
				upazila.setNameEng(rs.getString("NameEng"));
				upazila.setDistrictId(rs.getInt("DistrictId"));
				upazila.setActive(rs.getInt("Active"));
				upazila.setCreatedDate(rs.getTimestamp("CreatedDate"));
				upazila.setUpdatedDate(rs.getTimestamp("UpdatedDate"));
				return upazila;
			}

		});
	}

}
