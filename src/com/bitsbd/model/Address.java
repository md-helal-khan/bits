package com.bitsbd.model;

import java.sql.Timestamp;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

public class Address {
	
	private int addressId;
	private int applicantId;
	private String username;
	@NotEmpty
	private String homeAndRoadNo;
	@NotEmpty
	private String village;
	@NotEmpty
	private String unionName;
	@NotEmpty
	private String postOffice;
	@NotEmpty
	@Pattern(regexp = "^\\d+$")
	private String postCode;
	@NotNull
	@Positive
	private int upazilaId;
	@NotNull
	@Positive
	private int districtId;
	private int  addressType;
	private Timestamp createdDate;
	private Timestamp updatedDate;
	
	public Address() {
	}
	
	public Address(int applicantId,  String username, String homeAndRoadNo, String village, String unionName, String postOffice,
			String postCode, int upazilaId, int districtId, int addressType, Timestamp createdDate,
			Timestamp updatedDate) {
		this.applicantId = applicantId;
		this.username = username;
		this.homeAndRoadNo = homeAndRoadNo;
		this.village = village;
		this.unionName = unionName;
		this.postOffice = postOffice;
		this.postCode = postCode;
		this.upazilaId = upazilaId;
		this.districtId = districtId;
		this.addressType = addressType;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}

	public Address(int addressId, int applicantId,  String username, String homeAndRoadNo, String village, String unionName, String postOffice,
			String postCode, int upazilaId, int districtId, int addressType, Timestamp createdDate,
			Timestamp updatedDate) {
		this.addressId = addressId;
		this.applicantId = applicantId;
		this.username = username;
		this.homeAndRoadNo = homeAndRoadNo;
		this.village = village;
		this.unionName = unionName;
		this.postOffice = postOffice;
		this.postCode = postCode;
		this.upazilaId = upazilaId;
		this.districtId = districtId;
		this.addressType = addressType;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public int getApplicantId() {
		return applicantId;
	}
	
	public void setApplicantId(int applicantId) {
		this.applicantId = applicantId;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getHomeAndRoadNo() {
		return homeAndRoadNo;
	}

	public void setHomeAndRoadNo(String homeAndRoadNo) {
		this.homeAndRoadNo = homeAndRoadNo;
	}

	public String getVillage() {
		return village;
	}

	public void setVillage(String village) {
		this.village = village;
	}

	public String getUnionName() {
		return unionName;
	}

	public void setUnionName(String unionName) {
		this.unionName = unionName;
	}

	public String getPostOffice() {
		return postOffice;
	}

	public void setPostOffice(String postOffice) {
		this.postOffice = postOffice;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public int getUpazilaId() {
		return upazilaId;
	}

	public void setUpazilaId(int upazilaId) {
		this.upazilaId = upazilaId;
	}

	public int getDistrictId() {
		return districtId;
	}

	public void setDistrictId(int districtId) {
		this.districtId = districtId;
	}

	public int getAddressType() {
		return addressType;
	}

	public void setAddressType(int addressType) {
		this.addressType = addressType;
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
		return "Address [addressId=" + addressId + ", applicantId=" + applicantId + ", username=" + username
				+ ", homeAndRoadNo=" + homeAndRoadNo + ", village=" + village + ", unionName=" + unionName
				+ ", postOffice=" + postOffice + ", postCode=" + postCode + ", upazilaId=" + upazilaId + ", districtId="
				+ districtId + ", addressType=" + addressType + ", createdDate=" + createdDate + ", updatedDate="
				+ updatedDate + "]";
	}
}
