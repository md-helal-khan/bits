package com.bitsbd.model;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;

public class Applicant {

	private int applicantId;
	private int trackNo;
	private String username;
	private Long recruitmentId;
	@NotEmpty
	private String nameBan;
	@NotEmpty
	private String nameEng;
	@NotEmpty
	@Size(min=10, max=20)
	@Pattern(regexp = "^\\d+$")
	private String nidNo;
	@NotEmpty
	@Size(min=10, max=20)
	@Pattern(regexp = "^\\d+$")
	private String bridNo;
	@NotNull
	@Past
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dob;
	@NotNull
	@Positive
	private int placeOfBirth;
	@NotEmpty
	private String fatherName;
	@NotEmpty
	private String motherName;
	@Valid
	private List<Address> address;
	@Valid
	private ApplicantUser user;
	@NotEmpty
	private String nationality;
	@NotNull
	@Positive
	private int genderId;
	@NotNull
	@Positive
	private int religionId;
	@NotNull
	@Positive
	private int occupationId;
	@Valid
	private List<EducationalQualification> educationalQualification;
	@NotEmpty
	private String additionalQualification;
	@NotEmpty
	private String experience;
	@NotNull
	@Positive
	private int quotaId;
	@Valid
	private Payment payment;
	@NotNull
	@Positive
	private int divisionalCandidateId;
	private int isSelected;
	private Timestamp createdDate;
	private Timestamp updatedDate;
	
	public Applicant() {
	}
	
	public Applicant(int trackNo, String username, Long recruitmentId,  String nameBan,String nameEng, String nidNo,String bridNo, Date dob,
			 int placeOfBirth,  String fatherName,  String motherName, List<Address> address,  ApplicantUser user,  String nationality, int genderId,  int religionId,  
			 int occupationId, List<EducationalQualification> educationalQualification,  String additionalQualification, String experience,  int quotaId,  
			 Payment payment, int divisionalCandidateId, int isSelected, Timestamp createdDate, Timestamp updatedDate) {
		
		this.trackNo = trackNo;
		this.username = username;
		this.recruitmentId = recruitmentId;
		this.nameBan = nameBan;
		this.nameEng = nameEng;
		this.nidNo = nidNo;
		this.bridNo = bridNo;
		this.dob = dob;
		this.placeOfBirth = placeOfBirth;
		this.fatherName = fatherName;
		this.motherName = motherName;
		this.address = address;
		this.user = user;
		this.nationality = nationality;
		this.genderId = genderId;
		this.religionId = religionId;
		this.occupationId = occupationId;
		this.educationalQualification = educationalQualification;
		this.additionalQualification = additionalQualification;
		this.experience = experience;
		this.quotaId = quotaId;
		this.payment = payment;
		this.divisionalCandidateId = divisionalCandidateId;
		this.isSelected = isSelected;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}
	
	public Applicant(int applicantId, int trackNo, String username, Long recruitmentId,  String nameBan,String nameEng, String nidNo,String bridNo, Date dob,
			 int placeOfBirth,  String fatherName,  String motherName, List<Address> address,  ApplicantUser user,  String nationality, int genderId,  int religionId,  
			 int occupationId, List<EducationalQualification> educationalQualification,  String additionalQualification, String experience,  int quotaId,  
			 Payment payment, int divisionalCandidateId, int isSelected, Timestamp createdDate, Timestamp updatedDate) {
		
		this.applicantId = applicantId;
		this.trackNo = trackNo;
		this.username = username;
		this.recruitmentId = recruitmentId;
		this.nameBan = nameBan;
		this.nameEng = nameEng;
		this.nidNo = nidNo;
		this.bridNo = bridNo;
		this.dob = dob;
		this.placeOfBirth = placeOfBirth;
		this.fatherName = fatherName;
		this.motherName = motherName;
		this.address = address;
		this.user = user;
		this.nationality = nationality;
		this.genderId = genderId;
		this.religionId = religionId;
		this.occupationId = occupationId;
		this.educationalQualification = educationalQualification;
		this.additionalQualification = additionalQualification;
		this.experience = experience;
		this.quotaId = quotaId;
		this.payment = payment;
		this.divisionalCandidateId = divisionalCandidateId;
		this.isSelected = isSelected;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}
	
	public int getApplicantId() {
		return applicantId;
	}

	public void setApplicantId(int applicantId) {
		this.applicantId = applicantId;
	}

	public int getTrackNo() {
		return trackNo;
	}

	public void setTrackNo(int trackNo) {
		this.trackNo = trackNo;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Long getRecruitmentId() {
		return recruitmentId;
	}

	public void setRecruitmentId(Long recruitmentId) {
		this.recruitmentId = recruitmentId;
	}

	public String getNameBan() {
		return nameBan;
	}

	public void setNameBan(String nameBan) {
		this.nameBan = nameBan;
	}

	public String getNameEng() {
		return nameEng;
	}

	public void setNameEng(String nameEng) {
		this.nameEng = nameEng;
	}

	public String getNidNo() {
		return nidNo;
	}

	public void setNidNo(String nidNo) {
		this.nidNo = nidNo;
	}

	public String getBridNo() {
		return bridNo;
	}

	public void setBridNo(String bridNo) {
		this.bridNo = bridNo;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public int getPlaceOfBirth() {
		return placeOfBirth;
	}

	public void setPlaceOfBirth(int placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	public ApplicantUser getUser() {
		return user;
	}

	public void setUser(ApplicantUser user) {
		this.user = user;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public int getGenderId() {
		return genderId;
	}

	public void setGenderId(int genderId) {
		this.genderId = genderId;
	}

	public int getReligionId() {
		return religionId;
	}

	public void setReligionId(int religionId) {
		this.religionId = religionId;
	}

	public int getOccupationId() {
		return occupationId;
	}

	public void setOccupationId(int occupationId) {
		this.occupationId = occupationId;
	}

	public List<EducationalQualification> getEducationalQualification() {
		return educationalQualification;
	}

	public void setEducationalQualification(List<EducationalQualification> educationalQualification) {
		this.educationalQualification = educationalQualification;
	}

	public String getAdditionalQualification() {
		return additionalQualification;
	}

	public void setAdditionalQualification(String additionalQualification) {
		this.additionalQualification = additionalQualification;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public int getQuotaId() {
		return quotaId;
	}

	public void setQuotaId(int quotaId) {
		this.quotaId = quotaId;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public int getDivisionalCandidateId() {
		return divisionalCandidateId;
	}

	public void setDivisionalCandidateId(int divisionalCandidateId) {
		this.divisionalCandidateId = divisionalCandidateId;
	}

	public int getIsSelected() {
		return isSelected;
	}

	public void setIsSelected(int isSelected) {
		this.isSelected = isSelected;
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
		return "Applicant [applicantId=" + applicantId + ", trackNo=" + trackNo + ", username=" + username
				+ ", recruitmentId=" + recruitmentId + ", nameBan=" + nameBan + ", nameEng=" + nameEng + ", nidNo="
				+ nidNo + ", bridNo=" + bridNo + ", dob=" + dob + ", placeOfBirth=" + placeOfBirth + ", fatherName="
				+ fatherName + ", motherName=" + motherName + ", address=" + address + ", user=" + user
				+ ", nationality=" + nationality + ", genderId=" + genderId + ", religionId=" + religionId
				+ ", occupationId=" + occupationId + ", educationalQualification=" + educationalQualification
				+ ", additionalQualification=" + additionalQualification + ", experience=" + experience + ", quotaId="
				+ quotaId + ", payment=" + payment + ", divisionalCandidateId=" + divisionalCandidateId
				+ ", isSelected=" + isSelected + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + "]";
	}

	public String viewApplicant() {
		return "{\"success\": true,\"data\":"+this+",\"message\": null}";
	}
}
