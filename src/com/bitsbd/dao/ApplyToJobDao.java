package com.bitsbd.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bitsbd.model.Address;
import com.bitsbd.model.Applicant;
import com.bitsbd.model.EducationalQualification;

@Component("applyToJobDao")
public class ApplyToJobDao {
	
	private NamedParameterJdbcTemplate jdbc;

	@Autowired
	public void setDataSource(DataSource jdbc) {
		try {
			this.jdbc = new NamedParameterJdbcTemplate(jdbc);
		} catch (CannotGetJdbcConnectionException e) {
			System.out.println("Please check jdbc!");
		}
	}
	
	@Transactional
	public boolean applyToJob(Applicant applicant) {
		System.out.println(applicant);
		boolean b=true;
//		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(applicant);
//		boolean b = jdbc.update("INSERT INTO notices(name, email, text) VALUES (:name,:email,:text)", params) == 1;
//		insertEducation(applicant.getEducationalQualification());
//		insertAddress(applicant.getAddress());
		//INSERT INTO applicant(ApplicantId, TrackNo, Username, RecruitmentId, FirstNameBan, FirstNameEng, LastNameBan, LastNameEng, FatherNameBan, FatherNameEng, MotherNameBan, MotherNameEng, HusbandNameBan, HusbandNameEng, PermanentAddressId, PresentAddressId, genderId, DOB, NidNo, BridNo, BloodGroup, PlaceOfBirth, MeritalStatus, Nationality, ReligionId, OccupationId, ExperienceId, Experience, EducationalQualificationId, AdditionalQualification, QuotaId, BankDraftId, DivisionalCandidate, isSelected, CreatedDate, UpdatedDate) VALUES ([value-1],[value-2],[value-3],[value-4],[value-5],[value-6],[value-7],[value-8],[value-9],[value-10],[value-11],[value-12],[value-13],[value-14],[value-15],[value-16],[value-17],[value-18],[value-19],[value-20],[value-21],[value-22],[value-23],[value-24],[value-25],[value-26],[value-27],[value-28],[value-29],[value-30],[value-31],[value-32],[value-33],[value-34],[value-35],[value-36])
		return b;
	}
	
	
	
	@Transactional
	public int[] insertEducation(List<EducationalQualification> educationalQualification) {
		//SqlParameterSource[] params = SqlParameterSourceUtils.createBatch(notices.toArray());

		//return jdbc.batchUpdate("INSERT INTO notices(id,name, email, text) VALUES (:id, :name,:email,:text)", params);
		
		// INSERT INTO educationalqualification(EducationalQualificationId, ApplicantId, Username, Subject, EducationId, InstitutionName, PassingYear, BoardOrUniversity, GradeOrDivision, Grade, Division, CreatedDate, UpdatedDate) VALUES ([value-1],[value-2],[value-3],[value-4],[value-5],[value-6],[value-7],[value-8],[value-9],[value-10],[value-11],[value-12],[value-13])
		return new int[] {4,5,6,7,8};
	}
	
	@Transactional
	public int[] insertAddress(List<Address> addresses) {
		//SqlParameterSource[] params = SqlParameterSourceUtils.createBatch(notices.toArray());

		//return jdbc.batchUpdate("INSERT INTO notices(id,name, email, text) VALUES (:id, :name,:email,:text)", params);
		
		// INSERT INTO address(AddressId, ApplicantId, Username, HomeAndRoadNo, Village, UnionName, PostOffice, PostCode, UpazilaId, DistrictId, AddressType, CreatedDate, UpdatedDate) VALUES ([value-1],[value-2],[value-3],[value-4],[value-5],[value-6],[value-7],[value-8],[value-9],[value-10],[value-11],[value-12],[value-13])
		return new int[] {4,5,6,7,8};
	}
	
	
	

}
