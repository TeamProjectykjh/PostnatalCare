package com.team.postnatalcare.Nurse;

import javax.servlet.http.HttpServletRequest;


import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public String Nurse2(HttpServletRequest req, Model mo){
		int num = Integer.parseInt(req.getParameter("num"));
		String name = req.getParameter("name");
		int phone = Integer.parseInt(req.getParameter("phone"));
		mo.addAttribute("usernum", num);
		mo.addAttribute("username", name);
		mo.addAttribute("userphone", phone);
		return "inputnurseinfo";
	}
	@RequestMapping(value = "/nurseinfonext")
	public String Nurse3(MultipartHttpServletRequest multi){
		MultipartFile mf = multi.getFile("nurpath");
		String nurpath = mf.getOriginalFilename();
		int phone = Integer.parseInt(multi.getParameter("phone"));
		String name = multi.getParameter("name");
		String nurlicensename = multi.getParameter("nurlicensename");
		String nurserial = multi.getParameter("nurserial");
		String nurrecord = multi.getParameter("nurrecord");
		String nurcontent = multi.getParameter("nurcontent");
		
		NurseMapper dao = NursesqlSession.getMapper(NurseMapper.class);
		return "Nurseinfo";
	}
	
	

}
