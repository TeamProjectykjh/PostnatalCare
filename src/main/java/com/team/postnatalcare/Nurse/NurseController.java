package com.team.postnatalcare.Nurse;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;


import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.team.postnatalcare.Doctor.DoctorDTO;
import com.team.postnatalcare.Doctor.DoctorMapper;
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
	
	//CRUD
	@RequestMapping(value = "/Nurseinfo")
	public String Nurse1(HttpServletRequest req){
		
		return "Nurseinfo";
	}
	@RequestMapping(value = "/nursetest")
	public String nurset(HttpServletRequest req){
		
		return "redirect:nurselista";
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
	@RequestMapping(value = "/nurseinfonext", method = RequestMethod.POST)
	public String Nurse3(MultipartHttpServletRequest multi, HttpServletRequest req){
		
		int num = Integer.parseInt(req.getParameter("num"));		
		MultipartFile mf = multi.getFile("imgfile");
		String nurpath = mf.getOriginalFilename();		
		try(
				FileOutputStream fos = new FileOutputStream("C:/Users/home/Desktop/프젝/PostnatalCare/src/main/webapp/nurseimg" + nurpath);
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
		if(nurpath.equals("")) {
			nurpath = req.getParameter("imgdefault");
		}
		int phone = Integer.parseInt(req.getParameter("phone"));
		String name = req.getParameter("name");
		String nurlicensename = req.getParameter("nurlicensename");
		int nurserial = Integer.parseInt(req.getParameter("nurserial"));
		String nurrecord = req.getParameter("nurrecord");
		String nurcontent = req.getParameter("nurcontent");		
		NurseMapper dao = NursesqlSession.getMapper(NurseMapper.class);
		dao.insert(num , nurlicensename, nurpath, nurserial, nurrecord, nurcontent, name, phone);		
		System.out.println("/ num : "+num+"/ nurlicensename : "+nurlicensename+"/ nurpath : "+nurpath+"/ nurserial : "+nurserial
				+"/ nurrecord : "+nurrecord+"/ nurcontent : "+nurcontent+"/ name : "+name+"/ phone : "+phone);
		
		return "redirect:nurselista";
	}
	@RequestMapping(value = "/nurselista")
	public String Nurse7(HttpServletRequest req ,Model mo){	
		String name = req.getParameter("name");
		System.out.println("/name : "+name);
		NurseMapper dao = NursesqlSession.getMapper(NurseMapper.class);
		ArrayList<NursejoinDTO> list = dao.select();	
		
		mo.addAttribute("lista", list);		
		mo.addAttribute("names", name	);
		return "nurselist";
	}	
	
	@RequestMapping(value = "/nursedetail")
	public String nurse8(HttpServletRequest req, Model mo){
		NurseMapper dao = NursesqlSession.getMapper(NurseMapper.class);		
		int num = Integer.parseInt(req.getParameter("num"));
		String name = req.getParameter("name");
		String username=req.getParameter("username");
		int state =0;
		ArrayList<NursejoinDTO> list = dao.nursedetail(num);
		if(name.equals(username)) {
			state= 1;
			System.out.println(state);
		}
		System.out.println("num : "+num+" /name : "+name+" /username : "+username);
		mo.addAttribute("num", num);
		mo.addAttribute("name", name);
		mo.addAttribute("nurinfo", list);
		mo.addAttribute("state", state);
		
		return "nursedetail";
	}
	
	@RequestMapping(value = "/deletelist")
	public String Nurse5(HttpServletRequest req,Model mo){
		
		int nurnum = Integer.parseInt(req.getParameter("nurnum"));
		NurseMapper dao = NursesqlSession.getMapper(NurseMapper.class);
		dao.delete(nurnum);
		System.out.println("/nurnum : "+nurnum);
		return "redirect:nurselista";
	}
	@RequestMapping(value = "/modifyshh")
	public String Nurse6(HttpServletRequest req,Model mo){
		NurseMapper dao = NursesqlSession.getMapper(NurseMapper.class);
		
		int nurnum = Integer.parseInt(req.getParameter("nurnum"));
		String name = req.getParameter("name");
	
		ArrayList<NursejoinDTO> list = dao.modifyselect(nurnum);
		mo.addAttribute("name", name);		
		mo.addAttribute("mlist", list);
		System.out.println("nurnum : "+nurnum+" /name : "+name);
		return "modifyform";
	}
	
	@RequestMapping(value = "/modifysave", method = RequestMethod.POST)
	public String Nurse9(MultipartHttpServletRequest multi, HttpServletRequest req){
		NurseMapper dao = NursesqlSession.getMapper(NurseMapper.class);
		String nurlicensename = req.getParameter("nurlicensename");
		int nurserial = Integer.parseInt(req.getParameter("nurserial")) ;
		String nurrecord = req.getParameter("nurrecord");
		String nurcontent = req.getParameter("nurcontent");
		int nurnum = Integer.parseInt(req.getParameter("nurnum"));
		System.out.println(" /nurlicensename : "+nurlicensename+" /nurserial : "+nurserial+" /nurrecord : "
				+nurrecord+" /nurcontent : "+nurcontent+" /nurnum : "+nurnum);
		MultipartFile mf = multi.getFile("imgfile");
		String nurpath = mf.getOriginalFilename();
		System.out.println("nurpath : "+nurpath);
		try(
				FileOutputStream fos = new FileOutputStream("C:/Users/home/Desktop/프젝/PostnatalCare/src/main/webapp/nurseimg" + nurpath);
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
		if(nurpath.equals("")) {
			nurpath = req.getParameter("imgdefault");
		}
		
		dao.modifysava(nurpath, nurlicensename, nurserial, nurrecord, nurcontent, nurnum);
		
		
		return "redirect:nurselista";
	}
}
