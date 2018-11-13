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

@Component("recruitmentDao")
public class RecruitmentDao {

	private NamedParameterJdbcTemplate jdbc;

	@Autowired
	public void setDataSource(DataSource jdbc) {
		try {
			this.jdbc = new NamedParameterJdbcTemplate(jdbc);
		} catch (CannotGetJdbcConnectionException e) {
			System.out.println("Please check jdbc!");
		}

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

	public Recruitment getRecruitmentByID(Long id) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);

		return jdbc.queryForObject("SELECT * FROM Recruitment r JOIN Designation d ON r.DesignationId = d.DesignationId JOIN District di ON r.JobLocationId = di.DistrictId JOIN Education e ON e.EducationId = r.MinEducationalRequirement where r.Status = 1 and r.RecruitmentId = :id", params, new RowMapper<Recruitment>() {

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

}
