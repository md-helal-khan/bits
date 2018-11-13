package com.bitsbd.model;

import java.sql.Timestamp;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class EducationalQualification {
	
	private int educationalQualificationId;
	private int applicantId;
	private String username;
	@NotNull
	@Positive
	private int educationId;
	@NotEmpty
	private String subject;
	@NotEmpty
	private String institutionName;
	@NotNull
	@Positive
	private int passingYear;
	@NotEmpty
	private String boardOrUniversity;
	@NotEmpty
	private String gradeClassDivision;
	private Timestamp createdDate;
	private Timestamp updatedDate;
	
	public EducationalQualification() {
	}

	public EducationalQualification(int applicantId, String username, int educationId,  String subject,  String institutionName, int passingYear,  String boardOrUniversity,  String gradeClassDivision,Timestamp createdDate, Timestamp updatedDate) {
		this.applicantId = applicantId;
		this.username = username;
		this.educationId = educationId;
		this.subject = subject;
		this.institutionName = institutionName;
		this.passingYear = passingYear;
		this.boardOrUniversity = boardOrUniversity;
		this.gradeClassDivision = gradeClassDivision;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}
	
	public EducationalQualification(int educationalQualificationId, int applicantId, String username, int educationId,  String subject,  String institutionName, int passingYear,  String boardOrUniversity,  String gradeClassDivision, Timestamp createdDate, Timestamp updatedDate) {
		this.educationalQualificationId = educationalQualificationId;
		this.applicantId = applicantId;
		this.username = username;
		this.educationId = educationId;
		this.subject = subject;
		this.institutionName = institutionName;
		this.passingYear = passingYear;
		this.boardOrUniversity = boardOrUniversity;
		this.gradeClassDivision = gradeClassDivision;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}

	public int getEducationalQualificationId() {
		return educationalQualificationId;
	}

	public void setEducationalQualificationId(int educationalQualificationId) {
		this.educationalQualificationId = educationalQualificationId;
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

	public int getEducationId() {
		return educationId;
	}

	public void setEducationId(int educationId) {
		this.educationId = educationId;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getInstitutionName() {
		return institutionName;
	}

	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
	}

	public int getPassingYear() {
		return passingYear;
	}

	public void setPassingYear(int passingYear) {
		this.passingYear = passingYear;
	}

	public String getBoardOrUniversity() {
		return boardOrUniversity;
	}

	public void setBoardOrUniversity(String boardOrUniversity) {
		this.boardOrUniversity = boardOrUniversity;
	}

	public String getGradeClassDivision() {
		return gradeClassDivision;
	}

	public void setGradeClassDivision(String gradeClassDivision) {
		this.gradeClassDivision = gradeClassDivision;
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
		return "EducationalQualification [educationalQualificationId=" + educationalQualificationId + ", applicantId="
				+ applicantId + ", username=" + username + ", educationId=" + educationId + ", subject=" + subject
				+ ", institutionName=" + institutionName + ", passingYear=" + passingYear + ", boardOrUniversity="
				+ boardOrUniversity + ", gradeClassDivision=" + gradeClassDivision + ", createdDate=" + createdDate
				+ ", updatedDate=" + updatedDate + "]";
	}
}
