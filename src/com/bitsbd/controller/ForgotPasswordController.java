package com.bitsbd.controller;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bitsbd.model.User;
import com.bitsbd.service.AuthenticationService;
import com.bitsbd.service.ForgotPasswordService;
import com.bitsbd.utility.Utility;

@Controller
public class ForgotPasswordController {
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private ForgotPasswordService forgotPasswordService;
	
	@Autowired
	private AuthenticationService authenticationService;

	@RequestMapping(value="/forgot-password",method=RequestMethod.GET)
	public String forgotPassword(HttpServletRequest req, Model model) {
		if(Utility.isLoggedIn())
			return "redirect:home";
		return "ForgotPassword";
	}
	
	@RequestMapping(value="/forgot-password",method=RequestMethod.POST)
	public String forgotPasswordSubmit(Model model, HttpServletRequest request, String email) {
		try {
			if(authenticationService.isExistEmail(email)) {
				User user = forgotPasswordService.getUserForResetPasswordByMail(email);
				MimeMessage mimeMessage = mailSender.createMimeMessage();
				MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, false, "utf-8");
				mimeMessage.setContent(Utility.getMailbody(user, new Utility().getBaseUrl(request),2), "text/html; charset=UTF-8");
				helper.setTo(user.getEmail());
				helper.setSubject("Bits - reset password");
				mailSender.send(mimeMessage);
				model.addAttribute("status", "success");
			}else {
				model.addAttribute("status", "notExistance");
			}
			return "ForgotPassword";
		} catch (Exception e) {
			model.addAttribute("status", "error");
			return "ForgotPassword";
		}
	}
	
	@RequestMapping(value="/set-new-password",method=RequestMethod.GET)
	public String setNewPassword(HttpServletRequest req, Model model,String user, String key) {
		if(Utility.isLoggedIn())
			return "redirect:home";
		try {
			User user_ = new User();
			user_.setUsername(user);
			user_.setUserKey(key);
			if(forgotPasswordService.isSetNewPasswordEnabled(user_)) {
				model.addAttribute("user", user_);
				return "ResetPassword";
			}
			return "error/BadRequest";
		} catch (Exception e) {
			e.printStackTrace();
			return "error/BadRequest";
		}
	}
	
	@RequestMapping(value="/set-new-password",method=RequestMethod.POST)
	public String setNewPasswordSubmit(HttpServletRequest req, Model model,final RedirectAttributes redirectAttrs,User user) {
		if(Utility.isLoggedIn())
			return "redirect:home";
		try {
			if(!user.getPassword().isEmpty() && user.getPassword().matches("^\\S+$") && user.getPassword().length()>5 && user.getPassword().length()<31) {
				forgotPasswordService.setNewPassword(user);
				redirectAttrs.addFlashAttribute("setNewPassword", true);
				return "redirect:/Login";
			}else {
				model.addAttribute("status", "validation-error");
				return "ResetPassword";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("status", "error");
			return "ResetPassword";
		}
	}
}
