package com.bitsbd.model;


import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

public class Payment {
	
	private int paymentId;
	private int applicantId;
	private String username;
	private int paymentType;
	@NotEmpty
	private String paymentNo;
	@NotNull
	@Past
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date paymentDate;
	@NotEmpty
	private String bankName;
	@NotEmpty
	private String brunchName;
	private float amount;
	private Timestamp createdDate;
	private Timestamp updatedDate;
	
	public Payment() {
	}

	public Payment(int applicantId, String username, int paymentType,  String paymentNo, Date paymentDate,  String bankName,  String brunchName, float amount, Timestamp createdDate, Timestamp updatedDate) {
		this.applicantId = applicantId;
		this.username = username;
		this.paymentType = paymentType;
		this.paymentNo = paymentNo;
		this.paymentDate = paymentDate;
		this.bankName = bankName;
		this.brunchName = brunchName;
		this.amount = amount;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}
	
	public Payment(int paymentId, int applicantId, String username, int paymentType,  String paymentNo, Date paymentDate,  String bankName,  String brunchName, float amount, Timestamp createdDate, Timestamp updatedDate) {
		this.paymentId = paymentId;
		this.applicantId = applicantId;
		this.username = username;
		this.paymentType = paymentType;
		this.paymentNo = paymentNo;
		this.paymentDate = paymentDate;
		this.bankName = bankName;
		this.brunchName = brunchName;
		this.amount = amount;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
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

	public int getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(int paymentType) {
		this.paymentType = paymentType;
	}

	public String getPaymentNo() {
		return paymentNo;
	}

	public void setPaymentNo(String paymentNo) {
		this.paymentNo = paymentNo;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBrunchName() {
		return brunchName;
	}

	public void setBrunchName(String brunchName) {
		this.brunchName = brunchName;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
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
		return "Payment [paymentId=" + paymentId + ", applicantId=" + applicantId + ", username=" + username
				+ ", paymentType=" + paymentType + ", paymentNo=" + paymentNo + ", paymentDate=" + paymentDate
				+ ", bankName=" + bankName + ", brunchName=" + brunchName + ", amount=" + amount + ", createdDate="
				+ createdDate + ", updatedDate=" + updatedDate + "]";
	}
}
