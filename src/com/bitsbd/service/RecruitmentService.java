package com.bitsbd.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bitsbd.dao.RecruitmentDao;
import com.bitsbd.model.Recruitment;

@Service
public class RecruitmentService {
	
	@Autowired
	private RecruitmentDao recruitmentDao;
	
	public Recruitment getRecruitmentByID(Long id){
		return recruitmentDao.getRecruitmentByID(id);
	}

}
