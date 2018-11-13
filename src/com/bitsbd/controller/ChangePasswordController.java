package com.bitsbd.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitsbd.service.AuthenticationService;

@Controller
public class ChangePasswordController {
	
	private static final Logger logger = Logger.getLogger(HomeController.class);
	
	@Autowired
	private AuthenticationService authenticationService;
	
	@RequestMapping(value="/change-password",method=RequestMethod.GET)
	public String changePassword(HttpServletRequest req, Model model) {
		return "ChangePassword";
	}
	
	@RequestMapping(value="/change-password",method=RequestMethod.POST)
	public String changePasswordSubmit(Model model, HttpServletRequest request, String a) {
		logger.info(a);
		return "ChangePassword";
//		try {
//			if(authenticationService.isExistEmail(email)) {
////				User user = forgotPasswordService.getUserForResetPasswordByMail(email);
////				MimeMessage mimeMessage = mailSender.createMimeMessage();
////				MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, false, "utf-8");
////				mimeMessage.setContent(Utility.getMailbody(user, new Utility().getBaseUrl(request),2), "text/html; charset=UTF-8");
////				helper.setTo(user.getEmail());
////				helper.setSubject("Bits - reset password");
////				mailSender.send(mimeMessage);
////				model.addAttribute("status", "success");
//			}else {
//				model.addAttribute("status", "notExistance");
//			}
//			return "ChangePassword";
//		} catch (Exception e) {
//			model.addAttribute("status", "error");
//			return "ChangePassword";
//		}
	}

}
