package com.bitsbd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitsbd.dao.ApplyToJobDao;
import com.bitsbd.model.Applicant;

@Service("applyToJobService")
public class ApplyToJobService {

	@Autowired
	private ApplyToJobDao applyToJobDao;
	
	public boolean applyToJob(Applicant applicant) {
		return applyToJobDao.applyToJob(applicant);
	}
}
