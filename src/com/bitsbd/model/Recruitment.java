package com.bitsbd.model;

import java.math.BigInteger;
import java.sql.Date;
import java.sql.Timestamp;

public class Recruitment {

	  private Long recruitmentId;
	  private String memorandum;
	  private String paraOne;
	  private int designationId;
	  private String designationName;
	  private String salary;
	  private String grade;
	  private int positionNo;
	  private int jobLocationId;
	  private String jobLocation;
	  private Date applicationStartDate;
	  private Date applicationDeadline;
	  private int minEducationalRequirement;
	  private String minEducationalRequirementName;
	  private int maxEducationalRequirement;
	  private String maxEducationalRequirementName;
	  private int minAage;
	  private int maxAge;
	  private String education;
	  private String experience;
	  private String remarks;
	  private float applicationAmount;
	  private String amountCurrency;
	  private String applicationRules;
	  private String termsAndConditions;
	  private Date closeDate;
	  private int status;
	  private Timestamp createdDate;
	  private Timestamp updatedDate;
	  
	  
  
	  public Recruitment() {
		  
	  }
	  
	public Recruitment(Long recruitmentId, String memorandum, String paraOne, int designationId,
			String designationName, String salary, String grade, int positionNo, int jobLocationId, String jobLocation,
			Date applicationStartDate, Date applicationDeadline, int minEducationalRequirement,
			String minEducationalRequirementName, int maxEducationalRequirement, String maxEducationalRequirementName,
			int minAage, int maxAge, String education, String experience, String remarks, float applicationAmount,
			String amountCurrency, String applicationRules, String termsAndConditions, Date closeDate, int status,
			Timestamp createdDate, Timestamp updatedDate) {
		this.recruitmentId = recruitmentId;
		this.memorandum = memorandum;
		this.paraOne = paraOne;
		this.designationId = designationId;
		this.designationName = designationName;
		this.salary = salary;
		this.grade = grade;
		this.positionNo = positionNo;
		this.jobLocationId = jobLocationId;
		this.jobLocation = jobLocation;
		this.applicationStartDate = applicationStartDate;
		this.applicationDeadline = applicationDeadline;
		this.minEducationalRequirement = minEducationalRequirement;
		this.minEducationalRequirementName = minEducationalRequirementName;
		this.maxEducationalRequirement = maxEducationalRequirement;
		this.maxEducationalRequirementName = maxEducationalRequirementName;
		this.minAage = minAage;
		this.maxAge = maxAge;
		this.education = education;
		this.experience = experience;
		this.remarks = remarks;
		this.applicationAmount = applicationAmount;
		this.amountCurrency = amountCurrency;
		this.applicationRules = applicationRules;
		this.termsAndConditions = termsAndConditions;
		this.closeDate = closeDate;
		this.status = status;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}
	
	public Recruitment(String memorandum, String paraOne, int designationId,
			String designationName, String salary, String grade, int positionNo, int jobLocationId, String jobLocation,
			Date applicationStartDate, Date applicationDeadline, int minEducationalRequirement,
			String minEducationalRequirementName, int maxEducationalRequirement, String maxEducationalRequirementName,
			int minAage, int maxAge, String education, String experience, String remarks, float applicationAmount,
			String amountCurrency, String applicationRules, String termsAndConditions, Date closeDate, int status,
			Timestamp createdDate, Timestamp updatedDate) {
		this.memorandum = memorandum;
		this.paraOne = paraOne;
		this.designationId = designationId;
		this.designationName = designationName;
		this.salary = salary;
		this.grade = grade;
		this.positionNo = positionNo;
		this.jobLocationId = jobLocationId;
		this.jobLocation = jobLocation;
		this.applicationStartDate = applicationStartDate;
		this.applicationDeadline = applicationDeadline;
		this.minEducationalRequirement = minEducationalRequirement;
		this.minEducationalRequirementName = minEducationalRequirementName;
		this.maxEducationalRequirement = maxEducationalRequirement;
		this.maxEducationalRequirementName = maxEducationalRequirementName;
		this.minAage = minAage;
		this.maxAge = maxAge;
		this.education = education;
		this.experience = experience;
		this.remarks = remarks;
		this.applicationAmount = applicationAmount;
		this.amountCurrency = amountCurrency;
		this.applicationRules = applicationRules;
		this.termsAndConditions = termsAndConditions;
		this.closeDate = closeDate;
		this.status = status;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}
	
	
	public Long getRecruitmentId() {
		return recruitmentId;
	}
	public void setRecruitmentId(Long recruitmentId) {
		this.recruitmentId = recruitmentId;
	}
	public String getMemorandum() {
		return memorandum;
	}
	public void setMemorandum(String memorandum) {
		this.memorandum = memorandum;
	}
	public String getParaOne() {
		return paraOne;
	}
	public void setParaOne(String paraOne) {
		this.paraOne = paraOne;
	}
	public int getDesignationId() {
		return designationId;
	}
	public void setDesignationId(int designationId) {
		this.designationId = designationId;
	}
	public String getDesignationName() {
		return designationName;
	}
	public void setDesignationName(String designationName) {
		this.designationName = designationName;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public int getPositionNo() {
		return positionNo;
	}
	public void setPositionNo(int positionNo) {
		this.positionNo = positionNo;
	}
	public int getJobLocationId() {
		return jobLocationId;
	}
	public void setJobLocationId(int jobLocationId) {
		this.jobLocationId = jobLocationId;
	}
	public String getJobLocation() {
		return jobLocation;
	}
	public void setJobLocation(String jobLocation) {
		this.jobLocation = jobLocation;
	}
	public Date getApplicationStartDate() {
		return applicationStartDate;
	}
	public void setApplicationStartDate(Date applicationStartDate) {
		this.applicationStartDate = applicationStartDate;
	}
	public Date getApplicationDeadline() {
		return applicationDeadline;
	}
	public void setApplicationDeadline(Date applicationDeadline) {
		this.applicationDeadline = applicationDeadline;
	}
	public int getMinEducationalRequirement() {
		return minEducationalRequirement;
	}
	public void setMinEducationalRequirement(int minEducationalRequirement) {
		this.minEducationalRequirement = minEducationalRequirement;
	}
	public String getMinEducationalRequirementName() {
		return minEducationalRequirementName;
	}
	public void setMinEducationalRequirementName(String minEducationalRequirementName) {
		this.minEducationalRequirementName = minEducationalRequirementName;
	}
	public int getMaxEducationalRequirement() {
		return maxEducationalRequirement;
	}
	public void setMaxEducationalRequirement(int maxEducationalRequirement) {
		this.maxEducationalRequirement = maxEducationalRequirement;
	}
	public String getMaxEducationalRequirementName() {
		return maxEducationalRequirementName;
	}
	public void setMaxEducationalRequirementName(String maxEducationalRequirementName) {
		this.maxEducationalRequirementName = maxEducationalRequirementName;
	}
	public int getMinAage() {
		return minAage;
	}
	public void setMinAage(int minAage) {
		this.minAage = minAage;
	}
	public int getMaxAge() {
		return maxAge;
	}
	public void setMaxAge(int maxAge) {
		this.maxAge = maxAge;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public float getApplicationAmount() {
		return applicationAmount;
	}
	public void setApplicationAmount(float applicationAmount) {
		this.applicationAmount = applicationAmount;
	}
	public String getAmountCurrency() {
		return amountCurrency;
	}
	public void setAmountCurrency(String amountCurrency) {
		this.amountCurrency = amountCurrency;
	}
	public String getApplicationRules() {
		return applicationRules;
	}
	public void setApplicationRules(String applicationRules) {
		this.applicationRules = applicationRules;
	}
	public String getTermsAndConditions() {
		return termsAndConditions;
	}
	public void setTermsAndConditions(String termsAndConditions) {
		this.termsAndConditions = termsAndConditions;
	}
	public Date getCloseDate() {
		return closeDate;
	}
	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
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
		return "Recruitment [recruitmentId=" + recruitmentId + ", memorandum=" + memorandum + ", paraOne=" + paraOne
				+ ", designationId=" + designationId + ", designationName=" + designationName + ", salary=" + salary
				+ ", grade=" + grade + ", positionNo=" + positionNo + ", jobLocationId=" + jobLocationId
				+ ", jobLocation=" + jobLocation + ", applicationStartDate=" + applicationStartDate
				+ ", applicationDeadline=" + applicationDeadline + ", minEducationalRequirement="
				+ minEducationalRequirement + ", minEducationalRequirementName=" + minEducationalRequirementName
				+ ", maxEducationalRequirement=" + maxEducationalRequirement + ", maxEducationalRequirementName="
				+ maxEducationalRequirementName + ", minAage=" + minAage + ", maxAge=" + maxAge + ", education="
				+ education + ", experience=" + experience + ", remarks=" + remarks + ", applicationAmount="
				+ applicationAmount + ", amountCurrency=" + amountCurrency + ", applicationRules=" + applicationRules
				+ ", termsAndConditions=" + termsAndConditions + ", closeDate=" + closeDate + ", status=" + status
				+ ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + "]";
	}
	 
	  
}
