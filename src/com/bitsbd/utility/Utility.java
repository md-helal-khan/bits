package com.bitsbd.utility;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.multipart.MultipartFile;

import com.bitsbd.model.User;

public class Utility {
	
	@Autowired
	private JavaMailSender mailSender;
	
	public static int getGeneratedUniqueId() {     
        UUID idOne = UUID.randomUUID();
        String str=""+idOne;        
        int uid=str.hashCode();
        String filterStr=""+uid;
        str=filterStr.replaceAll("-", "");
        return Integer.parseInt(str);
    }
	
	public static String convertDate(Date date, String ptrn){
		try {
			SimpleDateFormat formatter = new SimpleDateFormat(ptrn);
			String format = formatter.format(date);
			return format;
		} catch (Exception e) {
			return null;
		}
	}
	
	public static String convertDate(Date date){
		try {
			return convertDate(date,"yyyy-MM-dd");
		} catch (Exception e) {
			return null;
		}
	}
	
	public static Boolean isLoggedIn() {Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken))
			return true;
		else 
			return false;
	}
	
	public static String getUsername() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
	
	public static String getImgByUsername(String username) throws IOException {
		if (username==null || username.equals(""))
			username = "avater";
		String img = System.getProperty("catalina.home")+"\\tmpFiles\\"+username+".png";
		BufferedImage bImage = ImageIO.read(new File(img));
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write(bImage, "jpg", baos);
		baos.flush();
		byte[] imageInByteArray = baos.toByteArray();
		baos.close();
		String b64 = DatatypeConverter.printBase64Binary(imageInByteArray);
		return b64;
	}
	
	public static String getAlphaNumeric(int len) {

		char[] ch = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();

	    char[] c = new char[len];
	    SecureRandom random = new SecureRandom();
	    for (int i = 0; i < len; i++) {
	      c[i] = ch[random.nextInt(ch.length)];
	    }
	    return new String(c);
	}
	
	public String getBaseUrl(HttpServletRequest req) {
	    return req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + req.getContextPath();
	}
	
	public boolean sendEmail(String mailBody, String subject, String sendTo) {
		try {
			MimeMessage mimeMessage = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, false, "utf-8");
			mimeMessage.setContent(mailBody, "text/html; charset=UTF-8");
			helper.setTo(sendTo);
			helper.setSubject(subject);
			mailSender.send(mimeMessage);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static String uploadImg(MultipartFile file, String username) {
		
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
	
	
	public static String getMailbody(User user,String path, int mailType) {
		String mailText="আপনার একাউন্ট টি সম্পুর্ন ভাবে তৈরি করা হয়ে গেছে । <br/>একাউন্ট টি সক্রিয় করার জন্য নিচের বাটন এ ক্লিক করুন", 
			   btnText="আপনার ইমেইলটি নিশ্চিত করুন", 
			   link=path+"/user-verification?user="+user.getUsername()+"&key="+user.getUserKey(),
			   image = path+"/static/images/govt_logo.png";
		
		if(mailType==2) {
			mailText="আপনার একাউন্ট এর পাসওয়ার্ড পুনরায় সেট করার জন্য নিচের বাটনে ক্লিক করুন";
			btnText="পাসওয়ার্ড সেট করুন";
			link=path+"/set-new-password?user="+user.getUsername()+"&key="+user.getUserKey();
		}
		
		//remove this before go production
		image = "https://seeklogo.com/images/G/govt-bangladesh-logo-D1143C363F-seeklogo.com.png";
			
		return "<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"	<head>\r\n" + 
				"	<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n" + 
				"	<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" + 
				"	<title></title>\r\n" + 
				"	</head>\r\n" + 
				"	<style>\r\n" + 
				"		body {\r\n" + 
				"			color: #2a2a2a;\r\n" + 
				"			font-family: Arial, sans-serif;\r\n" + 
				"			font-size: 18px;\r\n" + 
				"			width: 100% !important;\r\n" + 
				"			-webkit-text-size-adjust: 100%;\r\n" + 
				"			-ms-text-size-adjust: 100%;\r\n" + 
				"			margin: 0;\r\n" + 
				"			padding: 0;\r\n" + 
				"			margin-bottom: 20px;\r\n" + 
				"			line-height: 18px;\r\n" + 
				"		}\r\n" + 
				"		h1, h2, h3, h4, h5 {\r\n" + 
				"			font-weight: bold;\r\n" + 
				"		}\r\n" + 
				"		h1, h2, h3, h4, h5, p {\r\n" + 
				"			margin: 0;\r\n" + 
				"			padding: 0;\r\n" + 
				"		}\r\n" + 
				"		h1 {\r\n" + 
				"			font-size: 24px;\r\n" + 
				"			line-height: 32px;\r\n" + 
				"		}\r\n" + 
				"		h2 {\r\n" + 
				"			font-size: 20px;\r\n" + 
				"			line-height: 26px;\r\n" + 
				"		}\r\n" + 
				"		\r\n" + 
				"		h3 {\r\n" + 
				"			font-size: 18px;\r\n" + 
				"			line-height: 26px;\r\n" + 
				"		}\r\n" + 
				"		h4 {\r\n" + 
				"			font-size: 16px;\r\n" + 
				"			line-height: 26px;\r\n" + 
				"		}\r\n" + 
				"		h5 {\r\n" + 
				"			font-size: 14px;\r\n" + 
				"			line-height: 20px;\r\n" + 
				"		}\r\n" + 
				"		p {\r\n" + 
				"			font-size: 16px;\r\n" + 
				"			line-height: 22px;\r\n" + 
				"		}a {\r\n" + 
				"			color: #eb1478;\r\n" + 
				"			text-decoration: none;\r\n" + 
				"		}\r\n" + 
				"		ol {\r\n" + 
				"			list-style-position: inside;\r\n" + 
				"			margin: 0;\r\n" + 
				"			padding: 0;\r\n" + 
				"		}\r\n" + 
				"		\r\n" + 
				"		ul {\r\n" + 
				"			list-style-position: inside;\r\n" + 
				"			margin: 0;\r\n" + 
				"			padding: 0;\r\n" + 
				"		}\r\n" + 
				"		\r\n" + 
				"		li {\r\n" + 
				"			font-size: 18px;\r\n" + 
				"			line-height: 28px;\r\n" + 
				"			margin: 18px 10px;\r\n" + 
				"		}\r\n" + 
				"		li>a {\r\n" + 
				"			font-weight: bold;\r\n" + 
				"		}table.footer p {\r\n" + 
				"			line-height: 18px;\r\n" + 
				"		}\r\n" + 
				"		\r\n" + 
				"		table.footer a {\r\n" + 
				"			color: #2a2a2a;\r\n" + 
				"		}\r\n" + 
				"		table, td {\r\n" + 
				"			border-collapse: collapse;\r\n" + 
				"		}\r\n" + 
				"		p.header {\r\n" + 
				"			color: #eb1478;\r\n" + 
				"			font-size: 24px;\r\n" + 
				"		}\r\n" + 
				"		hr {\r\n" + 
				"			display: block;\r\n" + 
				"			height: 1px;\r\n" + 
				"			border: 0;\r\n" + 
				"			border-top: 1px solid #DDDDDD;\r\n" + 
				"			margin: 37px 0 30px;\r\n" + 
				"			padding: 0;\r\n" + 
				"			align: left;\r\n" + 
				"		}\r\n" + 
				"	</style>\r\n" + 
				"	<body class=\"perks \"\r\n" + 
				"		style=\"color: #2a2a2a; font-family: Arial, sans-serif; font-size: 18px; width: 100% !important; -webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; line-height: 18px; margin: 0 0 20px; padding: 0;\">\r\n" + 
				"		<div style=\"background-color: #eae9ea;\"></div>\r\n" + 
				"		<table height=\"100%\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\"\r\n" + 
				"			border=\"0\" bgcolor=\"#eae9ea\" style=\"border-collapse: collapse;\">\r\n" + 
				"			<tr>\r\n" + 
				"				<td valign=\"top\" align=\"center\" style=\"border-collapse: collapse;\">\r\n" + 
				"					<table width=\"600\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\"\r\n" + 
				"						class=\"main\"\r\n" + 
				"						style=\"border-collapse: collapse; margin-left: 30px; margin-right: 30px;\">\r\n" + 
				"						<tr>\r\n" + 
				"							<td align=\"left\" class=\"min_width\"\r\n" + 
				"								style=\"border-collapse: collapse; width: 600px;\">\r\n" + 
				"								<table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\"\r\n" + 
				"									bgcolor=\"#ffffff\"\r\n" + 
				"									style=\"border-collapse: collapse; margin-top: 10px;\" class=\"\">\r\n" + 
				"									<tr>\r\n" + 
				"										<td align=\"left\" style=\"border-collapse: collapse;\">\r\n" + 
				"	\r\n" + 
				"											<table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\"\r\n" + 
				"												style=\"border-collapse: collapse;\">\r\n" + 
				"												<tr style=\"margin: 0; padding: 0;\">\r\n" + 
				"													<td align=\"center\" style=\"border-collapse: collapse; border-spacing: 0; padding: 50px;\">\r\n" + 
				"														<div style=\"margin-bottom: 30px; text-align: left;\"\r\n" + 
				"															align=\"left\">\r\n" + 
				"															<a\r\n" + 
				"																href=\"#\"\r\n" + 
				"																utm_content=\"igg-header-logo\" utm_medium=\"email\"\r\n" + 
				"																style=\"color: #eb1478; text-decoration: none;\"> <img\r\n" + 
				"																alt=\"\" class=\"logo\"\r\n" + 
				"																src=\""+image+"\"\r\n" + 
				"																style=\"display: block; border: none;\" width=\"125\">\r\n" + 
				"															</a>\r\n" + 
				"														</div>\r\n" + 
				"\r\n" + 
				"														<p style=\"font-size: 22px; line-height: 22px; margin: 0; padding: 0;\" align=\"left\">\r\n" + 
				"															জনাব <b>"+user.getUserProfile().getFirstNameEng()+" "+user.getUserProfile().getLastNameEng()+"</b>,\r\n" + 
				"														</p>\r\n" + 
				"														<div style=\"text-align: left;\" align=\"left\">\r\n" + 
				"															<p style=\"font-size: 20px; line-height: 28px; margin: 20px 0 0; padding: 0;\">"+mailText+"</p>\r\n" + 
				"														</div>\r\n" + 
				"														<p\r\n" + 
				"															style=\"font-size: 20px; line-height: 22px; margin: 0; padding: 0;\">\r\n" + 
				"															<a href=\""+link+"\" style=\"margin-top: 40px; color: #ffffff; text-decoration: none; display: inline-block; font-family: sans-serif; font-size: 20px; line-height: 46px; text-align: center; -webkit-text-size-adjust: none; font-weight: bold; white-space: nowrap; text-transform: uppercase; background-color: #00A651; padding: 5px 50px;\">\r\n" + 
				"																"+btnText+"</a>\r\n" + 
				"														</p>\r\n" + 
				"														<div style=\"width: 100px; margin: 35px 0px; border: 1px solid #e9e9e9;\"></div>\r\n" + 
				"														<p style=\"font-size: 20px; line-height: 22px; margin: 0; padding: 0;\">\r\n" + 
				"															অনুরোধক্রমে,\r\n" + 
				"														</p>\r\n" + 
				"														<p style=\"font-size: 22px; font-weight: bold; line-height: 22px; margin: 10px 0 0; padding: 0;\">\r\n" + 
				"															নিয়োগ বিজ্ঞপ্তি টিম\r\n" + 
				"														</p>\r\n" + 
				"													</td>\r\n" + 
				"												</tr>\r\n" + 
				"											</table>\r\n" + 
				"	\r\n" + 
				"										</td>\r\n" + 
				"									</tr>\r\n" + 
				"								</table>\r\n" + 
				"								<table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" lass=\"footer\" style=\"border-collapse: collapse;\">\r\n" + 
				"									<tr>\r\n" + 
				"										<td align=\"center\" class=\"footer\"\r\n" + 
				"											style=\"border-collapse: collapse; padding: 30px;\">\r\n" + 
				"											<i style=\"font-size: 13px; font-family: Arial, sans-serif; color: #000001; line-height: 18px; margin: 0; padding: 0;\">\r\n" + 
				"												একাউন্ট যাচাই করার জন্য, এই ইমেইলটি নিয়োগ বিজ্ঞপ্তি সিস্টেম থেকে দেয়া হয়েছে |\r\n" + 
				"											</i>\r\n" + 
				"										</td>\r\n" + 
				"									</tr>\r\n" + 
				"								</table>\r\n" + 
				"	\r\n" + 
				"							</td>\r\n" + 
				"						</tr>\r\n" + 
				"					</table>\r\n" + 
				"				</td>\r\n" + 
				"			</tr>\r\n" + 
				"		</table>\r\n" + 
				"	</body>\r\n" + 
				"</html>	";
	}
	
	

}
