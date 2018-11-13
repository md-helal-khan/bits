package com.bitsbd.controller;

import java.util.List;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitsbd.model.Recruitment;
import com.bitsbd.service.HomeService;
import com.bitsbd.service.RecruitmentService;

@Controller
public class HomeController {
	
	private static final Logger logger = Logger.getLogger(HomeController.class);
	
	@Autowired
	private HomeService homeService;
	
	@Autowired
	private RecruitmentService recruitmentService;

	@RequestMapping(value={"/", "/home"})
	public String showHome(Model model, HttpSession session) {
//		logger.info("Project is running ...");
		List<Recruitment> recruitments = homeService.getRecruitments();
		model.addAttribute("recruitments", recruitments);
		//return "Home";
		return "Home";

	}

	@RequestMapping(value = "/JobDetails", method = RequestMethod.GET)
	public String jobDetails(Model model, @RequestParam("job") Long job) {
		Recruitment recruitment = recruitmentService.getRecruitmentByID(job);
		model.addAttribute("job", recruitment);
		return "JobDetails";
	}
}
