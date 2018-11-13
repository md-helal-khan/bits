package com.bitsbd.controller;

import java.util.List;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bitsbd.model.Upazila;
import com.bitsbd.service.AjaxService;
import com.bitsbd.service.AuthenticationService;

@Controller
@RequestMapping("/Ajax")
public class AjaxController {
	
	@Autowired
	private AjaxService ajaxService;
	
	private String errorResponse = "{\"success\": false,\"data\":null,\"message\": \"Somthing went wrong\"}";
	
	@RequestMapping(value="/GetUpazilaByDistrictId", method=RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String GetUpazilaByDistrictId(@RequestParam("id") int id) {
		
		try {
			if(id!=-1) {
				List<Upazila> upazilaList = ajaxService.getUpazilaByDistrictId(id);
				return "{\"success\": true,\"data\":"+new JSONArray(upazilaList)+",\"message\": null}";
				
			}else {
				return errorResponse;
			}
		} catch (Exception e) {
			return errorResponse;
		}
		
	}
}
