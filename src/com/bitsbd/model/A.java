package com.bitsbd.model;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Positive;

import org.springframework.format.annotation.DateTimeFormat;

public class A {
	@NotNull
	private int applicantId;
	@NotNull
	private int trackNo;
	@NotNull
	private int userProfileId;
	@NotNull
	private Long recruitmentId;
	@NotEmpty(message = "বাংলায় নাম লিখুন")
	@NotNull(message = "বাংলায় নাম লিখুন")
	private String nameBan;
	@NotEmpty(message = "ইংরেজিতে নাম লিখুন")
	@NotNull(message = "ইংরেজিতে নাম লিখুন")
	private String nameEng;
	@NotNull(message = "জাতীয় পরিচয় নম্বর লিখুন")
	@Positive(message = "জাতীয় পরিচয় নম্বর সংখ্যায় লিখুন")
	@Min(5)
	private int nidNo;
	@NotNull(message = "জন্ম নিবন্ধন নম্বর লিখুন")
	@Positive(message = "জন্ম নিবন্ধন নম্বর সংখ্যায় লিখুন")
	@Min(5)
	private int bridNo;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Past (message="জন্ম তারিখ সঠিক নয়")
	@NotNull(message = "জন্ম তারিখ সিলেক্ট করুন")
	private Date dob;
	@NotNull(message = "জন্মস্থান  সিলেক্ট করুন")
	@Positive(message = "জন্মস্থান  সিলেক্ট করুন")
	private int placeOfBirth;
	@NotEmpty(message = "পিতার নাম লিখুন")
	@NotNull(message = "পিতার নাম লিখুন")
	private String fatherNameBan;
	@NotEmpty(message = "মাতার নাম লিখুন")
	@NotNull(message = "মাতার নাম লিখুন")
	private String motherNameBan;
	@Valid
	private List<Address> address;
	@Valid
	private User user;
	@NotEmpty(message="জাতীয়তা লিখুন")
	@NotNull(message="জাতীয়তা লিখুন")
	private String nationality;
	@NotNull(message = "জেন্ডার সিলেক্ট করুন")
	@Positive(message = "জেন্ডার সিলেক্ট করুন")
	private int genderId;
	@NotNull(message = "ধর্ম সিলেক্ট করুন")
	@Positive(message = "ধর্ম সিলেক্ট করুন ")
	private int religionId;
	@NotNull(message = "পেশা সিলেক্ট করুন")
	@Positive(message = "পেশা সিলেক্ট করুন ")
	private int occupationId;
	@Valid
	private List<EducationalQualification> educationalQualification;
	@NotEmpty(message = "অতিরিক্ত যোগ্যতা লিখুন")
	@NotNull(message = "অতিরিক্ত যোগ্যতা লিখুন")
	private String additionalQualification;
	@NotEmpty(message = "অভিজ্ঞতার বিবরণ লিখুন")
	@NotNull(message = "অভিজ্ঞতার বিবরণ লিখুন")
	private String experience;
	@NotNull(message = "কোটাতে টিক দিন")
	@Positive(message = "কোটাতে টিক দিন")
	private int quotaId;
	@Valid
	private Payment payment;
	@NotNull(message = "বিভাগীয় প্রার্থী কিনা টিক দিন")
	@Positive(message = "বিভাগীয় প্রার্থী কিনা টিক দিন")
	private int divisionalCandidate;
	@NotNull
	private int isSelected;
	@NotNull
	private Timestamp createdDate;
	@NotNull
	private Timestamp updatedDate;
	
	

}
