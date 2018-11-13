package com.bitsbd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bitsbd.model.Upazila;
import com.bitsbd.dao.AjaxDao;
import java.util.List;

@Service("ajaxService")
public class AjaxService {
	
	@Autowired
	private AjaxDao ajaxDao;
	
	public List<Upazila> getUpazilaByDistrictId(int id){
		return ajaxDao.getUpazilaByDistrictId(id);
	}

}
