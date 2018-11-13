package com.bitsbd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitsbd.dao.ForgotPasswordDao;
import com.bitsbd.model.User;

@Service("forgotPasswordService")
public class ForgotPasswordService {
	@Autowired
	ForgotPasswordDao forgotPasswordDao;
	
	public User getUserByEmail(String email) {
		return forgotPasswordDao.getUserByEmail(email);
	}
	public boolean setEnableReset(String email) {
		return forgotPasswordDao.setEnableReset(email);
	}
	
	public User getUserForResetPasswordByMail(String email) {
		return forgotPasswordDao.getUserForResetPasswordByMail(email);
	}
	public boolean isSetNewPasswordEnabled(User user) {
		return forgotPasswordDao.isSetNewPasswordEnabled(user);
	}
	public boolean setNewPassword(User user) {
		return forgotPasswordDao.setNewPassword(user);
	}
}
