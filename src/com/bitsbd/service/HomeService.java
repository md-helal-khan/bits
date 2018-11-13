package com.bitsbd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitsbd.dao.HomeDao;
import com.bitsbd.model.Designation;
import com.bitsbd.model.District;
import com.bitsbd.model.Recruitment;
import com.bitsbd.model.User;

@Service("homeService")
public class HomeService {
	
	@Autowired
	private HomeDao homeDao;
	
	public List<Recruitment> getRecruitments(){
		return homeDao.getRecruitments();
	}
	
	public List<Designation> getDesignations(){
		return homeDao.getDesignations();
	}
	
	public List<District> getDistrict() {
		return homeDao.getDistrict();
	}
	
	
	

}
