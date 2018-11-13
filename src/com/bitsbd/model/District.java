package com.bitsbd.model;

import java.sql.Timestamp;

public class District {

	private int districtId;
	private String nameBan;
	private String NameEng;
	private int divisionId;
	private int active;
	private Timestamp createdDate;
	private Timestamp updatedDate;
	
	public District() {
		
	}
	
	public District(String nameBan, String nameEng, int divisionId, int active, Timestamp createdDate,
			Timestamp updatedDate) {
		super();
		this.nameBan = nameBan;
		NameEng = nameEng;
		this.divisionId = divisionId;
		this.active = active;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}

	public District(int districtId, String nameBan, String nameEng, int divisionId, int active, Timestamp createdDate,
			Timestamp updatedDate) {
		this.districtId = districtId;
		this.nameBan = nameBan;
		NameEng = nameEng;
		this.divisionId = divisionId;
		this.active = active;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}

	public int getDistrictId() {
		return districtId;
	}

	public void setDistrictId(int districtId) {
		this.districtId = districtId;
	}

	public String getNameBan() {
		return nameBan;
	}

	public void setNameBan(String nameBan) {
		this.nameBan = nameBan;
	}

	public String getNameEng() {
		return NameEng;
	}

	public void setNameEng(String nameEng) {
		NameEng = nameEng;
	}

	public int getDivisionId() {
		return divisionId;
	}

	public void setDivisionId(int divisionId) {
		this.divisionId = divisionId;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
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
		return "District [districtId=" + districtId + ", nameBan=" + nameBan + ", NameEng=" + NameEng + ", divisionId="
				+ divisionId + ", active=" + active + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate
				+ "]";
	}
	
	
	
	
}
