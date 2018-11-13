package com.bitsbd.model;

import java.sql.Timestamp;

public class Upazila {
	
	private int upazilaId;
	private String nameBan;
	private String nameEng;
	private int districtId;
	private int active;
	private Timestamp createdDate;
	private Timestamp updatedDate;
	
	public Upazila() {
	}
	
	public Upazila(String nameBan, String nameEng, int districtId, int active, Timestamp createdDate, Timestamp updatedDate) {
		this.nameBan = nameBan;
		this.nameEng = nameEng;
		this.districtId = districtId;
		this.active = active;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}
	
	public Upazila(int upazilaId, String nameBan, String nameEng, int districtId, int active, Timestamp createdDate,
			Timestamp updatedDate) {
		this.upazilaId = upazilaId;
		this.nameBan = nameBan;
		this.nameEng = nameEng;
		this.districtId = districtId;
		this.active = active;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}

	public int getUpazilaId() {
		return upazilaId;
	}

	public void setUpazilaId(int upazilaId) {
		this.upazilaId = upazilaId;
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

	public int getDistrictId() {
		return districtId;
	}

	public void setDistrictId(int districtId) {
		this.districtId = districtId;
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
		return "Upazila [upazilaId=" + upazilaId + ", nameBan=" + nameBan + ", nameEng=" + nameEng + ", districtId="
				+ districtId + ", active=" + active + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate
				+ "]";
	}
}
