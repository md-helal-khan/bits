package com.bitsbd.model;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class ApplicantOld {
	
//	private int applicantId; 
//	private int trackNo; 
//	private int userProfileId; 
//	private int recruitmentId; 
//	private String firstNameBan; 
//	private String lastNameEng; 
	private String fatherNameBan; 
//	private String fatherNameEng; 
	private String motherNameBan; 
//	private String motherNameEng; 
//	private String husbandNameBan; 
//	private String husbandNameEng; 
////	private Address permanentAddress;
////	private Address presentAddress; 
//	private String sex; 
//	private Date dob; 
//	private String nidNo; 
//	private String bridNo; 
//	private String bloodGroup; 
//	private int placeOfBirth; 
//	private int meritalStatus; 
//	private int nationality; 
//	private int religionId; 
//	private int occupationId; 
//	private int experienceId; 
//	private String experience; 
//	private List<EducationalQualification> educationalQualification;
//	private String additionalQualification; 
//	private int quotaId; 
//	private int bankDraftId; 
//	private int divisionalCandidate; 
//	private int isSelected; 
//	private Timestamp createdDate; 
//	private Timestamp updatedDate;
	
	public ApplicantOld() {
	}
	
	
	




	public ApplicantOld(String fatherNameBan, String motherNameBan) {
		this.fatherNameBan = fatherNameBan; //motherNameBan
		this.motherNameBan = motherNameBan;
		//this.educationalQualification = educationalQualification;
	}







	public String getFatherNameBan() {
		return fatherNameBan;
	}







	public void setFatherNameBan(String fatherNameBan) {
		this.fatherNameBan = fatherNameBan;
	}







	public String getMotherNameBan() {
		return motherNameBan;
	}







	public void setMotherNameBan(String motherNameBan) {
		this.motherNameBan = motherNameBan;
	}







	@Override
	public String toString() {
		return "Applicant [fatherNameBan=" + fatherNameBan + ", motherNameBan=" + motherNameBan + "]";
	}
	
	
	


}
