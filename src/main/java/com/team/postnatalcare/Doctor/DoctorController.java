package com.team.postnatalcare.Doctor;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team.postnatalcare.Sanhumanagement.SanhuMapper;




@Controller
public class DoctorController {
	
	private static final Logger logger = LoggerFactory.getLogger(DoctorController.class);
	
	
	@Autowired	
	SqlSession DoctorsqlSession;
	DoctorMapper dao;

	@RequestMapping(value = "/doctor")
	public String doctor(HttpServletRequest request,Model model) {	
		int num = Integer.parseInt(request.getParameter("num"));
		String name = request.getParameter("name");
		model.addAttribute("usernum", num);
		model.addAttribute("docname", name);
		return "doctorinfo";
	}
	
	@RequestMapping(value = "/doctorsave")
	public String doctorsave(HttpServletRequest request, Model mo) {		
		int num = Integer.parseInt(request.getParameter("num"));
		String doclicensename = request.getParameter("doclicensename");
		String docpath = request.getParameter("docpath");
		int docserial = Integer.parseInt(request.getParameter("docserial"));
		String docrecord = request.getParameter("docrecord");
		String doctorcontent = request.getParameter("doctorcontent");
		DoctorMapper dao = DoctorsqlSession.getMapper(DoctorMapper.class);
		System.out.println("num:"+num+" doclicensename:"+doclicensename+" docserial:"+docserial+" docrecord:"+docrecord+" doctorcontent:"+doctorcontent);
		dao.doctorsave(num, doclicensename,docpath, docserial, docrecord, doctorcontent);
		return "redirect:index";
		//사진 column, 생성인지 수정인지 구별가능한 column => 2개 column 추가
	}
	
	@RequestMapping(value = "/calendar")
	public String calendar() {	
		
		return "calendar";
	}

	

	
}
