package com.team.postnatalcare.Doctor;


import javax.servlet.http.HttpServletRequest;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

;


@Controller
public class DoctorController {
	
	private static final Logger logger = LoggerFactory.getLogger(DoctorController.class);
	
	
	@Autowired	
	SqlSession DoctorsqlSession;
	DoctorMapper dao;

	@RequestMapping(value = "/doctor", method = RequestMethod.GET)
	public String doctor() {		
		System.out.println("hi");
		return "testdoctor";
	}
	
	
	
}
