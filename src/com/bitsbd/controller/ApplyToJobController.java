package com.bitsbd.controller;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import org.apache.log4j.Logger;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;
import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.bitsbd.model.Applicant;
import com.bitsbd.model.Recruitment;
import com.bitsbd.service.AjaxService;
import com.bitsbd.service.ApplyToJobService;
import com.bitsbd.service.HomeService;
import com.bitsbd.service.RecruitmentService;
import com.bitsbd.utility.Utility;

@Controller
public class ApplyToJobController {
	
	private static final Logger logger = Logger.getLogger(ApplyToJobController.class);
	
	@Autowired
	private HomeService homeService;
	@Autowired
	private RecruitmentService recruitmentService;
	@Autowired
	private AjaxService ajaxService;
	@Autowired
	private ApplyToJobService applyToJobService;

	@RequestMapping(value = "/ApplyToJob", method = RequestMethod.GET)
	public String applyToJob(Model model, HttpSession session, @RequestParam("job") Long job) throws ParseException, IOException {
		try {
			Recruitment recruitment = recruitmentService.getRecruitmentByID(job);
			model.addAttribute("recruitment", recruitment);
			model.addAttribute("districts", homeService.getDistrict());
			model.addAttribute("applicant", new Applicant());
			model.addAttribute("img", Utility.getImgByUsername(""));
			return "ApplyToJob";
			
		} catch (IOException e) {
			Recruitment recruitment = recruitmentService.getRecruitmentByID(job);
			model.addAttribute("recruitment", recruitment);
			model.addAttribute("districts", homeService.getDistrict());
			model.addAttribute("applicant", new Applicant());
			model.addAttribute("img", Utility.getImgByUsername(""));
			model.addAttribute("error", true);
			return "ApplyToJob";
		}
	}
	
	@RequestMapping(value ="/ApplyToJob", method = RequestMethod.POST)
	public String getApplyToJob(Model model,
			@RequestParam("userPhoto") MultipartFile userPhoto,
			@ModelAttribute("applicant") @Validated Applicant applicant, 
			BindingResult result) throws IOException {
		
		try {
			Recruitment recruitment = recruitmentService.getRecruitmentByID(applicant.getRecruitmentId());
			model.addAttribute("recruitment", recruitment);
			model.addAttribute("districts", homeService.getDistrict());
			model.addAttribute("upazilas0", ajaxService.getUpazilaByDistrictId(applicant.getAddress().get(0).getDistrictId()));
			model.addAttribute("upazilas1", ajaxService.getUpazilaByDistrictId(applicant.getAddress().get(1).getDistrictId()));
			model.addAttribute("img", Utility.getImgByUsername(""));
			if(userPhoto.isEmpty()) {
				model.addAttribute("photoError", true);
				return "ApplyToJob";
			}
			if(result.hasErrors()) {
				return "ApplyToJob";
			}
			if(applyToJobService.applyToJob(applicant))
			{
				logger.info("Applied to job successfully");
				return "AppliedToJob";
			}
			return "ApplyToJob";
			
			
		} catch (Exception e) {
			e.printStackTrace();
			Recruitment recruitment = recruitmentService.getRecruitmentByID(applicant.getRecruitmentId());
			model.addAttribute("recruitment", recruitment);
			model.addAttribute("districts", homeService.getDistrict());
			model.addAttribute("applicant", new Applicant());
			model.addAttribute("img", Utility.getImgByUsername(""));
			model.addAttribute("error", true);
			return "ApplyToJob";
		}

	}
	
	@RequestMapping(value="/getPhoto/{username}" , method=RequestMethod.GET, produces="text/plain")
	@ResponseBody
	public String getPhoto(@PathVariable("username") String username) {
		String b64 = "";
		try {
			String img = "C:\\apache-tomcat-8.5.31\\tmpFiles\\Avater.png";
			BufferedImage bImage = ImageIO.read(new File(img));
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(bImage, "jpg", baos);
			baos.flush();
			byte[] imageInByteArray = baos.toByteArray();
			baos.close();
			b64 = DatatypeConverter.printBase64Binary(imageInByteArray);
			return "data:image/jpg;base64,"+b64;
			
		} catch (IOException e) {
			e.printStackTrace();
			e.getMessage();
			return b64;
		}
	}
	
	
	
	private String uploadImg(MultipartFile file, String username) {
		
		if(!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();
				//Create directory to store photo
				String rootPath = System.getProperty("catalina.home");
				File dir = new File(rootPath + File.separator + "images");
				System.out.println(dir);
				if(!dir.exists())
					dir.mkdirs();
				//Create the file on the server
				username = username+".jpg";
				File serverFile = new File(dir.getAbsolutePath() + File.separator + username);
				
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();
				return "";
				
			} catch (Exception e) {
			}
		}
		return "";
	}
}
