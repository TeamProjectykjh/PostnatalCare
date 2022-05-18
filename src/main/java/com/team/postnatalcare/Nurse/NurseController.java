package com.team.postnatalcare.Nurse;

import javax.servlet.http.HttpServletRequest;


import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.team.postnatalcare.Nurse.*;



/**
 * Handles requests for the application home page.
 */
@Controller
public class NurseController {
	
	private static final Logger logger = LoggerFactory.getLogger(NurseController.class);
	
	@Autowired
	SqlSession NursesqlSession;
	NurseMapper dao;
	
	//�ٹ�����
	@RequestMapping(value = "/calender")
	public String Calendar(HttpServletRequest req){
		
		return "calendar";
	}
	//CRUD
	@RequestMapping(value = "/Nurseinfo")
	public String Nurse1(HttpServletRequest req){
		
		return "Nurseinfo";
	}
	@RequestMapping(value = "/inputnurseinfo")
	public String Nurse2(HttpServletRequest req){
		
		return "inputnurseinfo";
	}
	@RequestMapping(value = "/nurseinfonext")
	public String Nurse3(MultipartHttpServletRequest multi){
		MultipartFile mf = multi.getFile("nurpath");
		String nurpath = mf.getOriginalFilename();
		String nurlicensename = multi.getParameter("nurlicensename");
		
		return "Nurseinfo";
	}
	
	

}
