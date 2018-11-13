package com.bitsbd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitsbd.dao.AuthenticationDao;
import com.bitsbd.model.User;

@Service("authenticationService")
public class AuthenticationService {
	
	@Autowired
	private AuthenticationDao authenticationDao;
	
	public boolean createAccount(User user) {
		return authenticationDao.createAccount(user);
	}
	public boolean userVerification(String username, String userKey) {
		return authenticationDao.userVerification(username, userKey);
	}
	public boolean isExist(String username) {
		return authenticationDao.isExist(username);
	}
	public boolean isExistEmail(String email) {
		return authenticationDao.isExistEmail(email);
	}
//	public User getUserByEmail(String email) {
//		return authenticationDao.getUserByEmail(email);
//	}
//	public boolean setEnableReset(String email) {
//		return authenticationDao.setEnableReset(email);
//	}
//	public boolean isSetNewPasswordEnabled(User user) {
//		return authenticationDao.isSetNewPasswordEnabled(user);
//	}
//	public boolean setNewPassword(User user) {
//		return authenticationDao.setNewPassword(user);
//	}
}
