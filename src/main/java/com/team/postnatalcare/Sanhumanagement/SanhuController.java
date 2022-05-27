package com.team.postnatalcare.Sanhumanagement;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

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
	public String sanhugg(HttpServletRequest request, Model mo) {		
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
	
	//
	@RequestMapping(value = "/sanhulicense")
	public String sanhulicense(HttpServletRequest request, Model mo) {		
		HttpSession hs = request.getSession();		
		return "sanhulicense";
	}
	
	//산후관리자의 상세정보를 출력
	@RequestMapping(value = "/sanhudetail")
	public String sanhutest(HttpServletRequest request, Model mo) {		
		HttpSession hs = request.getSession();
		SanhuMapper dao = SanhusqlSession.getMapper(SanhuMapper.class);
		int num = Integer.parseInt(request.getParameter("num"));
		SanhujoriDTO dto = dao.Sanhujoriout(num);
		mo.addAttribute("list", dto);
		return "sanhudetail";
	}
	
	@RequestMapping(value = "/aaaa")
	public String aaaa() {
		
		return "sanhutest";
	}
	
	
	@RequestMapping(value = "/rating")
	public String rating(HttpServletRequest request) {
		return "rating";
	}
	
	@RequestMapping(value = "/ratingsave")
	public String ratingsave(HttpServletRequest request) {
		int employnum, posnum, sanhunum;
		employnum = 1;
		posnum = 1;
		sanhunum = 1;
		float starpoint = Float.parseFloat(request.getParameter("rating"));
		String ment = request.getParameter("ment");
		SanhuMapper dao = SanhusqlSession.getMapper(SanhuMapper.class);
		dao.sanhureviewsave(employnum, posnum, sanhunum, starpoint, ment);
		return "redirect:/index";
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
		System.out.println(sanhupath);
		dao.sanhumodi(sanhurecord, content, sanhupath, sanhunum);
		return "redirect:index";
	}
	
	@RequestMapping(value = "/sanhuchoice")
	public String sanhuchoice(HttpServletRequest request, Model mo) {
		SanhuMapper dao = SanhusqlSession.getMapper(SanhuMapper.class);
		HttpSession hs = request.getSession();
		int num = (int)hs.getAttribute("num");
		SanhuNameDTO name = dao.namesearch(num);
		mo.addAttribute("name", name);
		return "sanhuchoice";
	}
}
