package com.bitsbd.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bitsbd.model.User;
import com.bitsbd.model.UserProfile;

@Component("forgotPasswordDao")
public class ForgotPasswordDao {
	
	private NamedParameterJdbcTemplate jdbc;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	public void setDataSource(DataSource jdbc) {
		try {
			this.jdbc = new NamedParameterJdbcTemplate(jdbc);
		} catch (CannotGetJdbcConnectionException e) {
			System.out.println("Please check jdbc!");
		}
	}
	
	public User getUserByEmail(String email) {
		return jdbc.queryForObject("SELECT * FROM user join userprofile using (Username) where Email = :email and Enabled = 1", 
				new MapSqlParameterSource("email",email), new org.springframework.jdbc.core.RowMapper<User>() {
			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				UserProfile userProfile = new UserProfile();
				userProfile.setFirstNameEng(rs.getString("FirstNameEng"));
				userProfile.setLastNameEng(rs.getString("LastNameEng"));
				User user = new User();
				user.setUserProfile(userProfile);
				user.setUsername(rs.getString("Username"));
				user.setEmail(email);
				user.setUserKey(rs.getString("UserKey"));
				return user;
			}
		});
	}
	
	public boolean setEnableReset(String email) {
		return jdbc.update("UPDATE user SET EnabledReset = 1 WHERE Email = :email"
				, new MapSqlParameterSource("email",email)) == 1;
	}
	
	@Transactional
	public User getUserForResetPasswordByMail(String email) {
		jdbc.update("UPDATE user SET EnabledReset = 1 WHERE Email = :email", new MapSqlParameterSource("email",email));
		return jdbc.queryForObject("SELECT * FROM user join userprofile using (Username) where Email = :email and Enabled = 1", 
				new MapSqlParameterSource("email",email), new org.springframework.jdbc.core.RowMapper<User>() {
			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				UserProfile userProfile = new UserProfile();
				userProfile.setFirstNameEng(rs.getString("FirstNameEng"));
				userProfile.setLastNameEng(rs.getString("LastNameEng"));
				User user = new User();
				user.setUserProfile(userProfile);
				user.setUsername(rs.getString("Username"));
				user.setEmail(email);
				user.setUserKey(rs.getString("UserKey"));
				return user;
			}
		});
	}
	
	public boolean isSetNewPasswordEnabled(User user) {
		MapSqlParameterSource userParams = new MapSqlParameterSource();
		userParams.addValue("username", user.getUsername());
		userParams.addValue("userKey", user.getUserKey());
		return jdbc.queryForObject("select count(*) from user where Username = :username and UserKey = :userKey and EnabledReset = 1", userParams, Integer.class) > 0;
	}
	
	@Transactional
	public boolean setNewPassword(User user) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("username", user.getUsername());
		params.addValue("password", passwordEncoder.encode(user.getPassword()));
		params.addValue("userKey", UUID.randomUUID().toString());
		return jdbc.update("UPDATE user SET Password = :password, UserKey = :userKey, EnabledReset = 0 and UpdatedDate = NOW() WHERE Username = :username", params) == 1;
	}
}
