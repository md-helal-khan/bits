package com.bitsbd.dao;

import java.util.UUID;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bitsbd.model.User;

@Component("authenticationDao")
public class AuthenticationDao {
	
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
	
	@Transactional
	public Boolean createAccount(User user) {
		BeanPropertySqlParameterSource userParams = new BeanPropertySqlParameterSource(user);
		
		user.setRole("ROLE_APPLICANT");
		user.setEnabled(false);
		
		MapSqlParameterSource userParams1 = new MapSqlParameterSource();
		userParams1.addValue("username", user.getUsername());
		userParams1.addValue("password", passwordEncoder.encode(user.getPassword()));
		userParams1.addValue("email", user.getEmail());
		userParams1.addValue("phone", user.getPhone());
		userParams1.addValue("enabled", user.isEnabled());
		userParams1.addValue("userKey", user.getUserKey());
		userParams1.addValue("role", user.getRole());
		
		
		MapSqlParameterSource userProfileParams = new MapSqlParameterSource();
		userProfileParams.addValue("username", user.getUsername());
		userProfileParams.addValue("firstNameEng", user.getUserProfile().getFirstNameEng());
		userProfileParams.addValue("lastNameEng", user.getUserProfile().getLastNameEng());
		
		
		try {
			jdbc.update("INSERT INTO userprofile (Username, FirstNameEng, LastNameEng) VALUES (:username,:firstNameEng,:lastNameEng)", userProfileParams);
			jdbc.update("INSERT INTO user (Username, Password, Email, Phone, Enabled, UserKey, EnabledReset) VALUES (:username,:password,:email,:phone,:enabled,:userKey, 0)", userParams1);
			return jdbc.update("INSERT INTO userrole (Username, Role) VALUES (:username,:role)", userParams1) == 1;
			
		} catch(DataAccessException e) {
			System.out.println(e.getMessage());
			return false;
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	@Transactional
	public boolean userVerification(String username, String userKey) {
		MapSqlParameterSource userParams = new MapSqlParameterSource();
		userParams.addValue("username", username);
		userParams.addValue("userKey", userKey);
		userParams.addValue("enabled", 0);
		
		if(jdbc.queryForObject("select count(*) from user where Username = :username and UserKey = :userKey and Enabled = :enabled", userParams, Integer.class)>0) {
			userParams.addValue("userKey", UUID.randomUUID().toString());
			userParams.addValue("enabled", 1);
			return jdbc.update("UPDATE user SET UserKey = :userKey, Enabled = :enabled WHERE Username = :username", userParams) == 1;
		}
		return false;
	}
	
	public boolean isExist(String username) {
		return jdbc.queryForObject("select count(*) from user where Username = :username ", 
			   new MapSqlParameterSource("username",username), Integer.class) > 0;
	}
	
	public boolean isExistEmail(String email) {
		return jdbc.queryForObject("select count(*) from user where Email = :email ", 
			   new MapSqlParameterSource("email",email), Integer.class) > 0;
	}
	
	
	
	
	
	
	
	
//	
//	
//	
//	public User getUserByEmail(String email) {
//		return jdbc.queryForObject("SELECT * FROM user join userprofile using (Username) where Email = :email and Enabled = 1", 
//				new MapSqlParameterSource("email",email), new org.springframework.jdbc.core.RowMapper<User>() {
//			@Override
//			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
//				UserProfile userProfile = new UserProfile();
//				userProfile.setFirstNameEng(rs.getString("FirstNameEng"));
//				userProfile.setLastNameEng(rs.getString("LastNameEng"));
//				User user = new User();
//				user.setUserProfile(userProfile);
//				user.setUsername(rs.getString("Username"));
//				user.setEmail(email);
//				user.setUserKey(rs.getString("UserKey"));
//				return user;
//			}
//		});
//	}
//	
//	public boolean setEnableReset(String email) {
//		return jdbc.update("UPDATE user SET EnabledReset = 1 WHERE Email = :email"
//				, new MapSqlParameterSource("email",email)) == 1;
//	}
//	
//	public boolean isSetNewPasswordEnabled(User user) {
//		MapSqlParameterSource userParams = new MapSqlParameterSource();
//		userParams.addValue("username", user.getUsername());
//		userParams.addValue("userKey", user.getUserKey());
//		return jdbc.queryForObject("select count(*) from user where Username = :username and UserKey = :userKey and EnabledReset = 1", userParams, Integer.class) > 0;
//	}
//	
//	@Transactional
//	public boolean setNewPassword(User user) {
//		MapSqlParameterSource params = new MapSqlParameterSource();
//		params.addValue("username", user.getUsername());
//		params.addValue("password", user.getPassword());
//		params.addValue("userKey", UUID.randomUUID().toString());
//		return jdbc.update("UPDATE user SET Password = :password, UserKey = :userKey, EnabledReset = 0 WHERE Username = :username", params) == 1;
//	}

}
