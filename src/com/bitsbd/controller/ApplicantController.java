package com.bitsbd.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bitsbd.model.Upazila;
import com.bitsbd.service.AjaxService;

@Controller
@RequestMapping("/Applicant")
public class ApplicantController {

	
	@RequestMapping(value = "/ApplyToJob", method = RequestMethod.GET)
	public String ApplyToJob() {
		return "ApplyToJob";
	}
	
}
