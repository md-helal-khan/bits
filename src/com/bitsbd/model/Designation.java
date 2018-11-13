package com.bitsbd.model;

import java.sql.Timestamp;

public class Designation {
	
	private int designationId;
	private String designationBan;
	private String designationEng;
	private int Active;
	private Timestamp CreatedDate;
	private Timestamp UpdatedDate;
	
	public Designation() {
	}

	public Designation(int designationId, String designationBan, String designationEng, int active, Timestamp createdDate, Timestamp updatedDate) {
		this.designationId = designationId;
		this.designationBan = designationBan;
		this.designationEng = designationEng;
		Active = active;
		CreatedDate = createdDate;
		UpdatedDate = updatedDate;
	}
	
	public Designation(String designationBan, String designationEng, int active, Timestamp createdDate, Timestamp updatedDate) {
		this.designationBan = designationBan;
		this.designationEng = designationEng;
		Active = active;
		CreatedDate = createdDate;
		UpdatedDate = updatedDate;
	}

	public int getDesignationId() {
		return designationId;
	}

	public void setDesignationId(int designationId) {
		this.designationId = designationId;
	}

	public String getDesignationBan() {
		return designationBan;
	}

	public void setDesignationBan(String designationBan) {
		this.designationBan = designationBan;
	}

	public String getDesignationEng() {
		return designationEng;
	}

	public void setDesignationEng(String designationEng) {
		this.designationEng = designationEng;
	}

	public int getActive() {
		return Active;
	}

	public void setActive(int active) {
		Active = active;
	}

	public Timestamp getCreatedDate() {
		return CreatedDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		CreatedDate = createdDate;
	}

	public Timestamp getUpdatedDate() {
		return UpdatedDate;
	}

	public void setUpdatedDate(Timestamp updatedDate) {
		UpdatedDate = updatedDate;
	}

	@Override
	public String toString() {
		return "Designation [designationId=" + designationId + ", designationBan=" + designationBan
				+ ", designationEng=" + designationEng + ", Active=" + Active + ", CreatedDate=" + CreatedDate
				+ ", UpdatedDate=" + UpdatedDate + "]";
	}
	
	
}
