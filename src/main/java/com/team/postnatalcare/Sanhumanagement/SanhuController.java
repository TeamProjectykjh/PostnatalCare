package com.team.postnatalcare.Sanhumanagement;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.team.postnatalcareMain.UserDTO;


@Controller
public class SanhuController {
	
	@Autowired	
	SqlSession SanhusqlSession;

	//산후관리사 관리 페이지 이동
	@RequestMapping(value = "/sanhugg")
	public String sanhugg(HttpServletRequest request, Model mo) {		
		SanhuMapper dao = SanhusqlSession.getMapper(SanhuMapper.class);
		//HttpSession hs = request.getSession();
		String job = "산후조리사";
		ArrayList<UserDTO> list = dao.jobsearch(job);
		mo.addAttribute("list", list);		
		return "sanhugg";
	}
	
	//산후관리사의 세부정보를 저장하기 위해 유저num을 작성폼으로 넘겨준다.
	@RequestMapping(value = "/sanhujoriinput")
	public String sanhumake(HttpServletRequest request, Model mo) {		
		int num = Integer.parseInt(request.getParameter("num"));
		mo.addAttribute("usernum", num);
		return "sanhujorisave";
	}
	
	//usernum은 유저테이블에서 가져온다
	@RequestMapping(value = "/sanhumakesave")
	public String sanhumakesave(HttpServletRequest request, Model mo) {		
		int usernum = Integer.parseInt(request.getParameter("usernum"));
		String sanhurecord = request.getParameter("sanhurecord");
		String content = request.getParameter("content");
		SanhuMapper dao = SanhusqlSession.getMapper(SanhuMapper.class);
		dao.sanhujorisave(usernum, sanhurecord, content);
		return "redirect:sanhugg";
		//사진 column, 생성인지 수정인지 구별가능한 column => 2개 column 추가
	}
	
	//
	@RequestMapping(value = "/sanhulicense")
	public String sanhulicense(HttpServletRequest request, Model mo) {		
		HttpSession hs = request.getSession();
		
		return "sanhulicense";
	}
	
	//산후관리자의 상세정보를 출력
	@RequestMapping(value = "/sanhutest")
	public String sanhutest(HttpServletRequest request, Model mo) {		
		HttpSession hs = request.getSession();
		SanhuMapper dao = SanhusqlSession.getMapper(SanhuMapper.class);
		int num = Integer.parseInt(request.getParameter("num"));
		SanhujoriDTO dto = dao.Sanhujoriout(num);
		mo.addAttribute("list", dto);
		return "sanhutest";
	}
	
}
