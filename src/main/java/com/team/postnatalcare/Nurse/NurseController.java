package com.team.postnatalcare.Nurse;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.sound.midi.MidiMessage;
import javax.sound.midi.Receiver;

import org.apache.catalina.User;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	//간호사 근무 일정
	@RequestMapping(value = "/Nursecalendar")
	public String Nursecalendar(HttpServletRequest req){
		
		return "calendar";
	}	
	
	//CRUD
	@RequestMapping(value = "/Nurseinfo")
	public String Nurseinfo(HttpServletRequest req){
		
		return "Nurseinfo";
	}	
	
	@RequestMapping(value = "/inputnurseinfo")
	public String inputnurseinfo(HttpServletRequest req, Model mo){
		int num = Integer.parseInt(req.getParameter("num"));
		String name = req.getParameter("name");
		int phone = Integer.parseInt(req.getParameter("phone"));		
		mo.addAttribute("usernum", num);
		mo.addAttribute("username", name);
		mo.addAttribute("userphone", phone);		
		return "inputnurseinfo";
	}
	@RequestMapping(value = "/nurseinfonext")
	public String nurseinfonext(MultipartHttpServletRequest multi, HttpServletRequest req) {		
				
	    MultipartFile mf = multi.getFile("nurpath"); // file형식의 nurpath라는 name을 가져오겠다
		String nurpath = mf.getOriginalFilename(); //파일명을 String 형식으로 받겠다
		try(							
				FileOutputStream fos = new FileOutputStream("E:/spring/PostnatalCare/src/main/webapp/nurseimg/" + nurpath);
			    //출력 파일의 저장 경로 지정
				InputStream is = mf.getInputStream();
				//
				){
		      int readCount = 0; // 한번에 읽어 들인 버퍼의 크기를 기록할 변수		     
		      byte[] buffer = new byte[500000]; //	stream 처리할 버퍼(1024바이트) 생성
		      while((readCount = is.read(buffer)) != -1){
 //스트림에서 최대 버퍼의 크기 만큼 스트림을 버퍼에 저장. 이때 저장된 크기를 readcount 변수에 저장
 //	read메서드를 실행 시킬때마다 스트림상 포인터가 1024바이트 만큼 이동하면서 순차적 처리
// readcount의 최대 크기는 1024byte가 되고, 더 이상 읽어드릴 스트림이 없으면 -1이 됨
//readcount가 -1, 즉 읽어드릴 스트림이 없다는 것은 스트림의 끝을 의미하므로 루프를 종료.	
		    	  fos.write(buffer,0,readCount);
		    	  //버퍼의 내용을 writer에 writing 함
		    	  //writing할 크기를 지정해 줘야 하는데, readcount 변수를 이용함
		    	  //즉, 0 ~ readcount 만큼을 buffer을 통해서 writing 하게 되는 것임
			   }
				   fos.flush();
			      fos.close();
			   }catch(Exception ex){
		      throw new RuntimeException("file Save Error");
			   }
							
		int num = Integer.parseInt(req.getParameter("num"));			      
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
		
		return "redirect:index";
	}
	@RequestMapping(value = "/nurselista")
	public String nurselista(HttpServletRequest req ,Model mo){	
		String name = req.getParameter("name");
		
		NurseMapper dao = NursesqlSession.getMapper(NurseMapper.class);
		ArrayList<NursejoinDTO> list = dao.select();	
		System.out.println("/name : "+name);
		mo.addAttribute("lista", list);		
		mo.addAttribute("names", name	);
		return "nurselist";
	}	
	
	@RequestMapping(value = "/nursedetail")
	public String nursedetail(HttpServletRequest req, Model mo){
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
	public String deletelist(HttpServletRequest req,Model mo){
		
		int nurnum = Integer.parseInt(req.getParameter("nurnum"));
		System.out.println("/nurnum : "+nurnum);
		NurseMapper dao = NursesqlSession.getMapper(NurseMapper.class);
		dao.delete(nurnum);
		
		return "redirect:nurselista";
	}
	@RequestMapping(value = "/modifyshh")
	public String modifyshh(HttpServletRequest req,Model mo){
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
	public String modifysave(MultipartHttpServletRequest multi, HttpServletRequest req){
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
				FileOutputStream fos = new FileOutputStream("E:/spring/PostnatalCare/src/main/webapp/nurseimg" + nurpath);
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
//
//	@RequestMapping(value = "/blah")
//	public String filesendprac(MultipartHttpServletRequest multi, HttpServletRequest req) throws Exception
//	{
//		MultipartFile mf = multi.getFile("imgfile");
//		String nurpath = mf.getOriginalFilename();
//		File file = new File("C:/Users/한호근/OneDrive/바탕 화면/프젝/PostnatalCare/src/main/webapp/nurseimg");
//		FileOutputStream fos = new FileOutputStream(file + nurpath);
//		InputStream is = mf.getInputStream();
//		
//		int readcount = 0;
//		byte[] buffer = new byte[1024];
//		while((readcount = is.read(buffer)) != -1) {
//			fos.write(buffer,0,readcount	);
//		}
//		
//		return "";
//				
//	}
//	public String nurseinfonext(MultipartHttpServletRequest multi, HttpServletRequest req, 
//			MultipartFile mp) throws IOException{	
//		
//				mp = multi.getFile("nurpath");
//				System.out.println("/mp : "+mp);
//				
//				String nurpath = mp.getOriginalFilename();					
//				System.out.println("/nurpath : "+nurpath);
//				
//				// 자신의 절대 경로 넣으면 됨
//				File file = new File("E:/spring/PostnatalCare/src/main/webapp/nurseimg/");
//				FileOutputStream fos = new FileOutputStream(file+nurpath);	
//				
//				System.out.println("/file+nurpath : "+file+nurpath);
//				System.out.println("/fos : "+fos);
//				
//				InputStream is = multi.getInputStream();			    
//				System.out.println("/is : "+is);
//				
//			      int readCount = 0; //읽음 성공 여부 저장용
//			      byte[] buffer = new byte[1024]; // 1024바이트씩 읽어서 저장
//			      System.out.println("/buffer : "+buffer);
//			      
//			      while((readCount = is.read(buffer)) != -1){
//			      fos.write(buffer,0,readCount);   			     
//			   
//			      }
}
