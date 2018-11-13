package com.bitsbd.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
	
	@RequestMapping(value="/user-profile",method=RequestMethod.GET)
	public String profile(HttpServletRequest req, Model model) {
		return "UserProfile";
	}
	
	@RequestMapping(value="/user-activity",method=RequestMethod.GET)
	public String history(HttpServletRequest req, Model model) {
		return "UserActivity";
	}

}
