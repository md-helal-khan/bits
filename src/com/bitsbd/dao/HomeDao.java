package com.bitsbd.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.ReturnedType;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bitsbd.model.Designation;
import com.bitsbd.model.District;
import com.bitsbd.model.Recruitment;
import com.bitsbd.model.User;

@Component("homeDao")
public class HomeDao {

	private NamedParameterJdbcTemplate jdbc;

	@Autowired
	public void setDataSource(DataSource jdbc) {
		try {
			this.jdbc = new NamedParameterJdbcTemplate(jdbc);
		} catch (CannotGetJdbcConnectionException e) {
			System.out.println("Please check jdbc!");
		}
		
	}
	
	public List<Designation> getDesignations(){
		return jdbc.query("select * from designation", new RowMapper<Designation>() {
			@Override
			public Designation mapRow(ResultSet rs, int rowNum) throws SQLException {
				Designation designation = new Designation();
				designation.setDesignationId(rs.getInt("DesignationId"));
				designation.setDesignationBan(rs.getString("DesignationBan"));
				designation.setDesignationEng(rs.getString("DesignationEng"));
				designation.setActive(rs.getInt("Active"));
				designation.setCreatedDate(rs.getTimestamp("CreatedDate"));
				designation.setUpdatedDate(rs.getTimestamp("UpdatedDate"));
				return designation;
			}
		});

	}

	
	public List<Recruitment> getRecruitments() {
		return jdbc.query("SELECT * FROM Recruitment r JOIN Designation d ON r.DesignationId = d.DesignationId JOIN District di ON r.JobLocationId = di.DistrictId JOIN Education e ON e.EducationId = r.MinEducationalRequirement where r.Status = 1", new RowMapper<Recruitment>() {
			@Override
			public Recruitment mapRow(ResultSet rs, int rowNum) throws SQLException {
				Recruitment recruitment=new Recruitment();
				recruitment.setRecruitmentId(rs.getLong("RecruitmentId"));
				recruitment.setMemorandum(rs.getString("Memorandum"));
				recruitment.setParaOne (rs.getString("ParaOne"));
				recruitment.setDesignationId(rs.getInt("DesignationId"));
				recruitment.setDesignationName(rs.getString("DesignationBan"));
				recruitment.setSalary(rs.getString("Salary"));
				recruitment.setGrade(rs.getString("Grade"));
				recruitment.setPositionNo(rs.getInt("PositionNo"));
				recruitment.setJobLocationId(rs.getInt("JobLocationId"));
				recruitment.setJobLocation(rs.getString("NameBan"));
				recruitment.setApplicationStartDate(rs.getDate("ApplicationStartDate"));
				recruitment.setApplicationDeadline(rs.getDate("ApplicationDeadline"));
				recruitment.setMinEducationalRequirement(rs.getInt("MinEducationalRequirement"));
				recruitment.setMaxEducationalRequirementName(rs.getString("EducationBan"));
				recruitment.setMaxEducationalRequirement(rs.getInt("MaxEducationalRequirement"));
				recruitment.setMaxEducationalRequirementName(rs.getString("EducationBan"));
				recruitment.setMinAage(rs.getInt("MinAage"));
				recruitment.setMaxAge(rs.getInt("MaxAge"));
				recruitment.setEducation(rs.getString("Education"));
				recruitment.setExperience(rs.getString("Experience"));
				recruitment.setRemarks(rs.getString("Remarks"));
				recruitment.setApplicationAmount(rs.getFloat("ApplicationAmount"));
				recruitment.setAmountCurrency(rs.getString("AmountCurrency"));
				recruitment.setApplicationRules(rs.getString("ApplicationRules"));
				recruitment.setTermsAndConditions(rs.getString("TermsAndConditions"));
				recruitment.setCloseDate(rs.getDate("CloseDate"));
				recruitment.setStatus(rs.getInt("Status"));
				recruitment.setCreatedDate(rs.getTimestamp("CreatedDate"));
				recruitment.setUpdatedDate(rs.getTimestamp("UpdatedDate"));
				return recruitment;
			}
		});
	}
	
	
	public Recruitment getRecruitmentById(Long recruitmentId) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("recruitmentId", recruitmentId);
		
		return jdbc.queryForObject("SELECT * FROM Recruitment r JOIN Designation d ON r.DesignationId = d.DesignationId JOIN District di ON r.JobLocationId = di.DistrictId JOIN Education e ON e.EducationId = r.MinEducationalRequirement where r.Status = 1 and r.RecruitmentId = :recruitmentId", params, new RowMapper<Recruitment>() {

			public Recruitment mapRow(ResultSet rs, int rowNum) throws SQLException {
				Recruitment recruitment=new Recruitment();
				recruitment.setRecruitmentId(rs.getLong("RecruitmentId"));
				recruitment.setMemorandum(rs.getString("Memorandum"));
				recruitment.setParaOne (rs.getString("ParaOne"));
				recruitment.setDesignationId(rs.getInt("DesignationId"));
				recruitment.setDesignationName(rs.getString("DesignationBan"));
				recruitment.setSalary(rs.getString("Salary"));
				recruitment.setGrade(rs.getString("Grade"));
				recruitment.setPositionNo(rs.getInt("PositionNo"));
				recruitment.setJobLocationId(rs.getInt("JobLocationId"));
				recruitment.setJobLocation(rs.getString("NameBan"));
				recruitment.setApplicationStartDate(rs.getDate("ApplicationStartDate"));
				recruitment.setApplicationDeadline(rs.getDate("ApplicationDeadline"));
				recruitment.setMinEducationalRequirement(rs.getInt("MinEducationalRequirement"));
				recruitment.setMaxEducationalRequirementName(rs.getString("EducationBan"));
				recruitment.setMaxEducationalRequirement(rs.getInt("MaxEducationalRequirement"));
				recruitment.setMaxEducationalRequirementName(rs.getString("EducationBan"));
				recruitment.setMinAage(rs.getInt("MinAage"));
				recruitment.setMaxAge(rs.getInt("MaxAge"));
				recruitment.setEducation(rs.getString("Education"));
				recruitment.setExperience(rs.getString("Experience"));
				recruitment.setRemarks(rs.getString("Remarks"));
				recruitment.setApplicationAmount(rs.getFloat("ApplicationAmount"));
				recruitment.setAmountCurrency(rs.getString("AmountCurrency"));
				recruitment.setApplicationRules(rs.getString("ApplicationRules"));
				recruitment.setTermsAndConditions(rs.getString("TermsAndConditions"));
				recruitment.setCloseDate(rs.getDate("CloseDate"));
				recruitment.setStatus(rs.getInt("Status"));
				recruitment.setCreatedDate(rs.getTimestamp("CreatedDate"));
				recruitment.setUpdatedDate(rs.getTimestamp("UpdatedDate"));
				return recruitment;
			}

		});
	}
	
	public Recruitment getRecruitmentForApplyToJobById(Long recruitmentId) {
		return null;
	}

	public List<District> getDistrict() {
		return jdbc.query("SELECT * FROM district", new RowMapper<District>() {
			public District mapRow(ResultSet rs, int rowNum) throws SQLException {
				District district = new District();
				district.setDistrictId(rs.getInt("DistrictId"));
				district.setNameBan(rs.getString("NameBan"));
				district.setNameEng(rs.getString("NameEng"));
				district.setDivisionId(rs.getInt("DivisionId"));
				district.setActive(rs.getInt("Active"));
				district.setCreatedDate(rs.getTimestamp("CreatedDate"));
				district.setUpdatedDate(rs.getTimestamp("UpdatedDate"));
				return district;
			}

		});
	}
	
/*
	public Notice getNotice(int id) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);

		return jdbc.queryForObject("Select * from notices where id = :id", params, new RowMapper<Notice>() {

			public Notice mapRow(ResultSet rs, int rowNum) throws SQLException {
				Notice notice = new Notice();
				notice.setId(rs.getInt("id"));
				notice.setName(rs.getString("name"));
				notice.setEmail(rs.getString("email"));
				notice.setText(rs.getString("text"));
				return notice;
			}

		});

	}

	public Boolean delete(int id) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);

		return jdbc.update("delete from notices where id = :id", params) == 1;
	}

	public Boolean create(Notice notice) {
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(notice);

		return jdbc.update("INSERT INTO notices(name, email, text) VALUES (:name,:email,:text)", params) == 1;
	}

	public Boolean update(Notice notice) {
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(notice);

		return jdbc.update("UPDATE notices SET name=:name, email=:email, text=:text WHERE id=:id", params) == 1;
	}

	
	
	
	
	// Batch create
	public int[] create(List<Notice> notices) {
		SqlParameterSource[] params = SqlParameterSourceUtils.createBatch(notices.toArray());

		return jdbc.batchUpdate("INSERT INTO notices(name, email, text) VALUES (:name,:email,:text)", params);
	}
	

	@Transactional
	public int[] createWithTransactional(List<Notice> notices) {
		SqlParameterSource[] params = SqlParameterSourceUtils.createBatch(notices.toArray());

		return jdbc.batchUpdate("INSERT INTO notices(id,name, email, text) VALUES (:id, :name,:email,:text)", params);
	}*/

}
