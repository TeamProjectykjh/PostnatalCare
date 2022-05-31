package com.team.postnatalcare.Sanhumanagement;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.team.postnatalcare.Sanmo.PostnatalDTO;
import com.team.postnatalcareMain.UserDTO;

@Controller
public class SanhuController {
	
	@Autowired	
	SqlSession SanhusqlSession;
	
	@RequestMapping(value = "/sanhumakesave")
	public String sanhumakesave(HttpServletRequest request, Model mo, MultipartHttpServletRequest multi) {		
		MultipartFile mf = multi.getFile("imgfile");
		String sanhupath = mf.getOriginalFilename();
		try(
				FileOutputStream fos = new FileOutputStream("C:/Spring/PostnatalCare/src/main/webapp/sanhuimg" + sanhupath);
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
		int usernum = Integer.parseInt(request.getParameter("usernum"));
		String sanhurecord = request.getParameter("sanhurecord");
		String content = request.getParameter("content");
		SanhuMapper dao = SanhusqlSession.getMapper(SanhuMapper.class);
		dao.sanhujorisave(usernum, sanhurecord, content, sanhupath);
		return "redirect:index";
	}

	//산후관리사 관리 페이지 이동
	@RequestMapping(value = "/sanhuinfo")
	public String sanhuinfo(HttpServletRequest request, Model mo) {		
		SanhuMapper dao = SanhusqlSession.getMapper(SanhuMapper.class);
		//HttpSession hs = request.getSession();
		ArrayList<SanhuNameDTO> list = dao.jobsearch();
		mo.addAttribute("list", list);
		return "sanhuinfo";
	}
	
	//산후관리사의 세부정보를 저장하기 위해 유저num을 작성폼으로 넘겨준다.
	@RequestMapping(value = "/sanhujoriinput")
	public String sanhumake(HttpServletRequest request, Model mo) {		
		int num = Integer.parseInt(request.getParameter("num"));
		mo.addAttribute("usernum", num);
		return "sanhujorisave";
	}
	
	//산후관리자의 상세정보를 출력
	@RequestMapping(value = "/sanhudetail")
	public String sanhudetail(HttpServletRequest request, Model mo) {		
		HttpSession hs = request.getSession();
		int usernum = (int)hs.getAttribute("num");
		int empstate = (int)hs.getAttribute("empstate");
		SanhuMapper dao = SanhusqlSession.getMapper(SanhuMapper.class);
		int num = Integer.parseInt(request.getParameter("num"));
		int state = Integer.parseInt(request.getParameter("state"));
		SanhujoriDTO dto = dao.Sanhujoriout(num);
		int sanhunum = dto.getSanhunum();
		ArrayList<PostnatalDTO> posnumf = dao.posnumfind(usernum);
		if(!posnumf.isEmpty()) {
			int posnum = posnumf.get(0).getPosnum();
		    mo.addAttribute("posnum", posnum);
			hs.setAttribute("sanhunum", sanhunum);
		}
		ArrayList<SanhuReviewDTO> reviewlist = dao.reviewout(sanhunum);
		if(!reviewlist.isEmpty()) {
			mo.addAttribute("reviewlist", reviewlist);
			float reviewavg = dao.reviewavg(sanhunum);
			mo.addAttribute("reviewavg", reviewavg);
		}
		if(state == 1) {
			SanhuEmployDTO empdto = dao.period(sanhunum);
			mo.addAttribute("empdto", empdto);
		}
		mo.addAttribute("list", dto);
		mo.addAttribute("empstate", empstate);
		mo.addAttribute("state", state);
		return "sanhudetail";
	}
	
	@RequestMapping(value = "/sanhumodify")
	public String sanhumodify(HttpServletRequest request, Model mo) {	
		HttpSession hs = request.getSession();
		SanhuMapper dao = SanhusqlSession.getMapper(SanhuMapper.class);
		int num = (int)hs.getAttribute("num");
		SanhujoriDTO dto = dao.Sanhujoriout(num);
		SanhuNameDTO name = dao.namesearch(num);
		mo.addAttribute("list", dto);
		mo.addAttribute("name", name);
		return "sanhujorimodify";
	}
	
	@RequestMapping(value = "/sanhumodifysave")
	public String sanhumodifysave(HttpServletRequest request, MultipartHttpServletRequest multi) {
		SanhuMapper dao = SanhusqlSession.getMapper(SanhuMapper.class);
		String content = request.getParameter("content");
		int sanhunum = Integer.parseInt(request.getParameter("sanhunum"));
		String sanhurecord = request.getParameter("sanhurecord");
		MultipartFile mf = multi.getFile("imgfile");
		String sanhupath = mf.getOriginalFilename();
		if(sanhupath.equals("")) {
			sanhupath = request.getParameter("imgdefault");
		}
		try(
				FileOutputStream fos = new FileOutputStream("C:/Spring/PostnatalCare/src/main/webapp/sanhuimg" + sanhupath);
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
		dao.sanhumodi(sanhurecord, content, sanhupath, sanhunum);
		return "redirect:index";
	}
	
	@RequestMapping(value = "/sanhuchoice")
	public String sanhuchoice(HttpServletRequest request, Model mo) {
		SanhuMapper dao = SanhusqlSession.getMapper(SanhuMapper.class);
		HttpSession hs = request.getSession();
		int num = (int)hs.getAttribute("num");
		SanhuNameDTO name = dao.namesearch(num);
	    SanhujoriDTO dto = dao.Sanhujoriout(num);
	    int sanhunum = dto.getSanhunum();
		mo.addAttribute("name", name);
		ArrayList<SanhuLicenseDTO> licenselist = dao.sanhuliout(sanhunum);
	    mo.addAttribute("licenselist", licenselist);
		return "sanhuchoice";
	}
	
	@RequestMapping(value = "/sanhulicense")
	   public String sanhulicense(HttpServletRequest request, Model mo) {      
	      HttpSession hs = request.getSession();      
	      SanhuMapper dao = SanhusqlSession.getMapper(SanhuMapper.class);
	      int num = (int)hs.getAttribute("num");
		  SanhujoriDTO dto = dao.Sanhujoriout(num);
		  int sanhunum = dto.getSanhunum();
	      ArrayList<SanhuLicenseDTO> licenselist = dao.sanhuliout(sanhunum);
	      mo.addAttribute("licenselist", licenselist);
	      return "sanhulicense";
	   }
	   
	   @RequestMapping(value = "/licensesave")
	   public String licensesave(HttpServletRequest request, Model mo) {
	      SanhuMapper dao = SanhusqlSession.getMapper(SanhuMapper.class);
	      HttpSession hs = request.getSession();
	      int num = (int)hs.getAttribute("num");
	      SanhujoriDTO dto = dao.Sanhujoriout(num);
	      int sanhunum = dto.getSanhunum();
	      String name = request.getParameter("name");
	      String code = request.getParameter("code");
	      dao.sanhulisave(sanhunum, name, code);
	      return "redirect:sanhulicense";
	   }
	   
	   @RequestMapping(value = "/licensedel")
	   public String licensedel(HttpServletRequest request, Model mo) {
	      SanhuMapper dao = SanhusqlSession.getMapper(SanhuMapper.class);
	      HttpSession hs = request.getSession();
	      int linum = Integer.parseInt(request.getParameter("linum"));
	      dao.sanhulidel(linum);
	      return "redirect:sanhulicense";
	   }
	   
	   @RequestMapping(value = "/licensemodi")
	   public String licensemodi(HttpServletRequest request, Model mo) {
	      SanhuMapper dao = SanhusqlSession.getMapper(SanhuMapper.class);
	      int modilinum = Integer.parseInt(request.getParameter("modilinum"));
	      String modiliname = request.getParameter("modiliname");
	      String modilicode = request.getParameter("modilicode");
	      dao.sanhulimodi(modilinum, modiliname, modilicode);
	      return "redirect:sanhulicense";
	   }
	   	   
	   @RequestMapping(value = "/checkboxdel", method=RequestMethod.POST)
	   public String checkboxdel(HttpServletRequest request, Model mo, @RequestParam(value="checkBoxArr[]") List<String> checkBoxArr) {
	      SanhuMapper dao = SanhusqlSession.getMapper(SanhuMapper.class);
	      String checkNum = "";
	      for(String str : checkBoxArr){
	    	    checkNum = str;
		    	int fnum = Integer.parseInt(checkNum);
		    	dao.sanhulidel(fnum);
		    }
	      return "redirect:sanhulicense";
	   }
	   
	   @RequestMapping(value = "/employment")
	   public String employment(HttpServletRequest request, Model mo) throws ParseException {
	      SanhuMapper dao = SanhusqlSession.getMapper(SanhuMapper.class);
	      HttpSession hs = request.getSession();
	      String empdate = request.getParameter("empdate");
	      int adddate = Integer.parseInt(request.getParameter("date"));
	      int sanhunum = Integer.parseInt(request.getParameter("sanhunum"));
	      dao.jobstatechange(sanhunum, 1);
	      int num = (int)hs.getAttribute("num");
	      ArrayList<PostnatalDTO> dto = dao.posnumfind(num);
	      int posnum = dto.get(0).getPosnum();
	      DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	      Date date = df.parse(empdate);
	      Calendar cal = Calendar.getInstance();
	      cal.setTime(date);
	      cal.add(Calendar.DATE, adddate);
	      String enddate = df.format(cal.getTime());
	      dao.sanhuemploymentsave(sanhunum, posnum, empdate, enddate);
	      return "redirect:index";
	   }
	   
	   @RequestMapping(value = "/jobcancel")
	   public String jobcancel(HttpServletRequest request) {
	      SanhuMapper dao = SanhusqlSession.getMapper(SanhuMapper.class);
	      HttpSession hs = request.getSession();
	      int sanhunum = (int)hs.getAttribute("sanhunum");
	      dao.jobstatechange(sanhunum, 0);
	      return "redirect:sanhuinfo";
	   }
	  
}
