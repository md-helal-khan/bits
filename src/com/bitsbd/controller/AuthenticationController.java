package com.bitsbd.controller;

import java.util.UUID;

import javax.mail.AuthenticationFailedException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailAuthenticationException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bitsbd.model.User;
import com.bitsbd.model.UserProfile;
import com.bitsbd.service.AuthenticationService;
import com.bitsbd.utility.Utility;


@Controller
public class AuthenticationController {
	
	private String errorResponse = "{\"success\": false,\"data\":null,\"message\": \"Somthing went wrong\"}";
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private AuthenticationService authenticationService;
	
	@RequestMapping("/Login")
	public String loginPage(Model model) {
		if(Utility.isLoggedIn())
			return "redirect:home";
		if(model.asMap().get("verification")!=null)
			model.addAttribute("verification", (boolean) model.asMap().get("verification"));
		if(model.asMap().get("setNewPassword")!=null)
			model.addAttribute("setNewPassword", (boolean) model.asMap().get("setNewPassword"));
		return "Login";
	}
	
	@RequestMapping(value="/UserRegistration", method=RequestMethod.GET)
	public String createAccountForm(Model model) {
		if(Utility.isLoggedIn())
			return "redirect:home";
		model.addAttribute("user", new User());
			return "UserRegistration";

	}
	
	@RequestMapping(value="/UserRegistration", method=RequestMethod.POST)
	public String createAccountSubmit(Model model, HttpServletRequest request,
			@ModelAttribute("user") @Validated User user, BindingResult result) {
		if(Utility.isLoggedIn())
			return "redirect:home";
		boolean isUserCreated = false;
		try {
			if(authenticationService.isExist(user.getUsername())) {
				result.rejectValue("username", "DuplicateKey.user.username");
				return "UserRegistration";
			}
			if(authenticationService.isExistEmail(user.getEmail())) {
				result.rejectValue("email", "DuplicateKey.user.email");
				return "UserRegistration";
			}
			if(result.hasErrors()) {
				return "UserRegistration";
			}
			user.setUserKey(UUID.randomUUID().toString());
			isUserCreated = authenticationService.createAccount(user);
			if(isUserCreated) {
				MimeMessage mimeMessage = mailSender.createMimeMessage();
				MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, false, "utf-8");
				mimeMessage.setContent(Utility.getMailbody(user, new Utility().getBaseUrl(request),1), "text/html; charset=UTF-8");
				helper.setTo(user.getEmail());
				helper.setSubject("Bits - user verification");
				mailSender.send(mimeMessage);
			}
			model.addAttribute("reg", isUserCreated);
			return "UserRegistration";
			
		} catch (Exception e) {
			model.addAttribute("reg", isUserCreated);
			return "UserRegistration";
		}
	}
	
	@RequestMapping(value="/user-verification",method=RequestMethod.GET)
	public String accountVerification(String user, String key, final RedirectAttributes redirectAttrs) {
		if(Utility.isLoggedIn())
			return "redirect:home";
		if(authenticationService.userVerification(user, key)) {
			redirectAttrs.addFlashAttribute("verification", true);
			return "redirect:/Login";
		}
		return "error/BadRequest";
	}
	
	
	
	
	
	
	
	
	
	
	
	/*
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
				User user = authenticationService.getUserByEmail(email);
				authenticationService.setEnableReset(email);
				//upper two lin merge in one
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
			if(authenticationService.isSetNewPasswordEnabled(user_)) {
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
				redirectAttrs.addFlashAttribute("setNewPassword", true);
				return "redirect:/Login";
			}else {
				model.addAttribute("status", "validation-error");
				return "ResetPassword";
			}
		} catch (Exception e) {
			model.addAttribute("status", "error");
			return "ResetPassword";
		}
	}
	
	*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping(value="/checkUsername", method=RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String CheckUsername(@RequestParam("username") String username) {
		try {
			if(username!=null || username!="") {
				boolean isExist = authenticationService.isExist(username);
				return "{\"success\": true,\"data\":"+isExist+",\"message\": null}";
			}
			return errorResponse;
			
		} catch (Exception e) {
			return errorResponse;
		}
	}
	
	@RequestMapping(value="/checkEmail", method=RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String CheckEmail(@RequestParam("email") String email) {
		try {
			if(email!=null || email!="") {
				boolean isExist = authenticationService.isExistEmail(email);
				return "{\"success\": true,\"data\":"+isExist+",\"message\": null}";
			}
			return errorResponse;
		} catch (Exception e) {
			return errorResponse;
		}
	}
}
