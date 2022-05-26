package com.team.postnatalcare.Doctor;


import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

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
	public String doctorsave(HttpServletRequest request, Model mo,MultipartHttpServletRequest mp) {		
		MultipartFile mf = mp.getFile("docpath");
		String docpath = mf.getOriginalFilename();
		try(
				FileOutputStream fos = new FileOutputStream("/PostnatalCare/src/main/webapp/doctorimg/" + docpath);
			    InputStream is = mf.getInputStream();
			    ){
			      int readCount = 0;
			      byte[] buffer = new byte[1024];
			      while((readCount = is.read(buffer)) != -1){
			      fos.write(buffer,0,readCount);
			    }
			    }catch(Exception ex){
			      throw new RuntimeException("file Save Error");
			}
		int num = Integer.parseInt(request.getParameter("num"));
		String doclicensename = request.getParameter("doclicensename");
		
		int docserial = Integer.parseInt(request.getParameter("docserial"));
		String docrecord = request.getParameter("docrecord");
		String doctorcontent = request.getParameter("doctorcontent");
		DoctorMapper dao = DoctorsqlSession.getMapper(DoctorMapper.class);
		System.out.println("num:"+num+" doclicensename:"+doclicensename+" docserial:"+docserial+" docrecord:"+docrecord+" doctorcontent:"+doctorcontent);
		dao.doctorsave(num, doclicensename,docpath, docserial, docrecord, doctorcontent);
		return "redirect:index";
	}
	
	@RequestMapping(value = "/calendar")
	public String calendar() {	
		
		return "calendar";
	}

	@RequestMapping(value = "/doctordetail")
	public String doctordetail(HttpServletRequest request,Model mo) {	
		DoctorMapper dao = DoctorsqlSession.getMapper(DoctorMapper.class);
		//HttpSession hs = request.getSession();
		int num = Integer.parseInt(request.getParameter("num"));
		String name = request.getParameter("name");
		ArrayList<DoctorDTO> list = dao.doctordetail(num);
		mo.addAttribute("num", num);
		mo.addAttribute("name", name);
		mo.addAttribute("docinfo", list);
		return "doctordetail";
	}
	
	@RequestMapping(value = "/doctormodify")
	public String doctormodify(HttpServletRequest request,Model mo) {	
		DoctorMapper dao = DoctorsqlSession.getMapper(DoctorMapper.class);
		//HttpSession hs = request.getSession();
		int docnum = Integer.parseInt(request.getParameter("docnum"));
		String name = request.getParameter("name");
		
		ArrayList<DoctorDTO> list = dao.docmodify(docnum);
		mo.addAttribute("name", name);
		mo.addAttribute("docinfo", list);
		return "doctormodify";
	}
	
	@RequestMapping(value = "/docmodifysave")
	public String sanhumodifysave(HttpServletRequest request, MultipartHttpServletRequest multi) {
		DoctorMapper dao = DoctorsqlSession.getMapper(DoctorMapper.class);
		int docnum = Integer.parseInt(request.getParameter("docnum"));
		String doclicensename = request.getParameter("doclicensename");
		int docserial = Integer.parseInt(request.getParameter("docserial"));
		String docrecord = request.getParameter("docrecord");
		String doctorcontent = request.getParameter("doctorcontent");
		MultipartFile mf = multi.getFile("imgfile");
		String docpath = mf.getOriginalFilename();
		try(
				FileOutputStream fos = new FileOutputStream("/PostnatalCare/src/main/webapp/doctorimg/" + docpath);
			    InputStream is = mf.getInputStream();
			    ){
			      int readCount = 0;
			      byte[] buffer = new byte[1024];
			      while((readCount = is.read(buffer)) != -1){
			      fos.write(buffer,0,readCount);
			    }
			    }catch(Exception ex){
			      throw new RuntimeException("file Save Error");
			}
		if(docpath.equals("")) {
			docpath = request.getParameter("imgdefault");
		}
		dao.docmodifysave(doclicensename,docpath,docserial,docrecord,doctorcontent, docnum);
		return "redirect:index";
	}
	
}
