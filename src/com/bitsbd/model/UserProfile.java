package com.bitsbd.model;

import java.sql.Timestamp;
import javax.validation.constraints.NotEmpty;

public class UserProfile {
	
	private int userProfileId;
	private int userId;
//	@NotEmpty
	private String firstNameBan;
	@NotEmpty
	private String firstNameEng;
//	@NotEmpty
	private String lastNameBan;
	@NotEmpty
	private String lastNameEng;
	private Timestamp createdDate;
	private Timestamp updatedDate;
	
	public UserProfile() {
	}
	
	public UserProfile(int userId, String firstNameBan, String firstNameEng, String lastNameBan, String lastNameEng, Timestamp createdDate, Timestamp updatedDate) {
		this.userId = userId;
		this.firstNameBan = firstNameBan;
		this.firstNameEng = firstNameEng;
		this.lastNameBan = lastNameBan;
		this.lastNameEng = lastNameEng;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}

	public UserProfile(int userProfileId, int userId, String firstNameBan, String firstNameEng, String lastNameBan, String lastNameEng, Timestamp createdDate, Timestamp updatedDate) {
		this.userProfileId = userProfileId;
		this.userId = userId;
		this.firstNameBan = firstNameBan;
		this.firstNameEng = firstNameEng;
		this.lastNameBan = lastNameBan;
		this.lastNameEng = lastNameEng;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}

	public int getUserProfileId() {
		return userProfileId;
	}

	public void setUserProfileId(int userProfileId) {
		this.userProfileId = userProfileId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstNameBan() {
		return firstNameBan;
	}

	public void setFirstNameBan(String firstNameBan) {
		this.firstNameBan = firstNameBan;
	}

	public String getFirstNameEng() {
		return firstNameEng;
	}

	public void setFirstNameEng(String firstNameEng) {
		this.firstNameEng = firstNameEng;
	}

	public String getLastNameBan() {
		return lastNameBan;
	}

	public void setLastNameBan(String lastNameBan) {
		this.lastNameBan = lastNameBan;
	}

	public String getLastNameEng() {
		return lastNameEng;
	}

	public void setLastNameEng(String lastNameEng) {
		this.lastNameEng = lastNameEng;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public Timestamp getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Timestamp updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Override
	public String toString() {
		return "UserProfile [userProfileId=" + userProfileId + ", userId=" + userId + ", firstNameBan=" + firstNameBan
				+ ", firstNameEng=" + firstNameEng + ", lastNameBan=" + lastNameBan + ", lastNameEng=" + lastNameEng
				+ ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + "]";
	}
}
