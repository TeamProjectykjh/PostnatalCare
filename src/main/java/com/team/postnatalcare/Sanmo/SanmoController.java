package com.team.postnatalcare.Sanmo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;import org.apache.catalina.User;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.team.postnatalcare.Sanmo.PostnatalDTO;
import com.team.postnatalcare.Sanmo.SanmoMapper;
import com.team.postnatalcareMain.Mapper;
import com.team.postnatalcareMain.UserDTO;
import com.team.postnatalcare.Sanmo.DocDTO;
import com.team.postnatalcare.Sanmo.NurDTO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class SanmoController {
	
	private static final Logger logger = LoggerFactory.getLogger(SanmoController.class);
	
	
	@Autowired
	SqlSession SanmosqlSession;
	SanmoMapper dao;

	@RequestMapping(value = "/reservation")  // �궛紐④컻�씤�젙蹂� �럹�씠吏�濡� 媛�湲�
	public String reservation(HttpServletRequest request,Model mo) {
		int num = Integer.parseInt(request.getParameter("num"));
		dao = SanmosqlSession.getMapper(SanmoMapper.class);
		ArrayList<UserDTO> list = dao.username(num);
		ArrayList<DocDTO> dlist = dao.docname();
		ArrayList<NurDTO> nlist = dao.nurname();
		mo.addAttribute("list", list);
		mo.addAttribute("dlist", dlist);
		mo.addAttribute("nlist", nlist);
		return "reservation"; 
	}
	
	@RequestMapping(value = "/reservationlist")  // �궛紐⑥삁�빟 �럹�씠吏�濡� 媛�湲�
	public String reservationlist(HttpServletRequest request,Model mo) {
		int num = Integer.parseInt(request.getParameter("num"));
		int docnum = Integer.parseInt(request.getParameter("docnum"));
		int nurnum = Integer.parseInt(request.getParameter("nurnum"));
		String startday = request.getParameter("startday");
		String endday = request.getParameter("endday");
		String baby = request.getParameter("baby");
		String protect = request.getParameter("protect");
		int emergencyphone = Integer.parseInt(request.getParameter("emergencyphone"));
		dao = SanmosqlSession.getMapper(SanmoMapper.class);
		dao.insertsave(num,docnum,nurnum,startday,endday,baby,protect,emergencyphone);
		System.out.println("num:"+num+"docnum:"+docnum+"nurnum:"+nurnum+"startday:"+startday+"endday:"+endday+"baby:"+baby+"protect:"+protect+"emergencyphone:"+emergencyphone);
		return "redirect:index";
	
	}

	@RequestMapping(value = "/reservationlistout")
	public String reservationlistout(HttpServletRequest request,Model mo) {
		dao = SanmosqlSession.getMapper(SanmoMapper.class);
		int num = Integer.parseInt(request.getParameter("num"));
		ArrayList<UserDTO> list = dao.username(num);
		ArrayList<DocnameDTO> dlist = dao.doctorname(num);
		ArrayList<NurnameDTO> nlist = dao.nursename(num);
		ArrayList<PostnatalDTO> clist = dao.poslist(num);
		mo.addAttribute("list", list);
		mo.addAttribute("dlist", dlist);
		mo.addAttribute("nlist", nlist);
		mo.addAttribute("clist", clist);
		
		return "reservationlistout";
	}
	
	
	@RequestMapping(value = "/Self-Checker")
	public String SelfChecker(HttpServletRequest request,Model mo) {
		int num = Integer.parseInt(request.getParameter("num"));
		dao = SanmosqlSession.getMapper(SanmoMapper.class);
		ArrayList<UserDTO> list = dao.username(num);
		ArrayList<PostnatalDTO> plist = dao.sanmonum(num);
		mo.addAttribute("list", list);
		mo.addAttribute("plist", plist);
		return "Self-Checker";
	}
	
	@RequestMapping(value = "/selfsave")
	public String Selfsave(HttpServletRequest request) {
		int posnum = Integer.parseInt(request.getParameter("posnum"));
		String qusday = request.getParameter("qusday");
		String quscondition = request.getParameter("quscondition");
		String quspain = request.getParameter("quspain");
		String qusdiscomfort = request.getParameter("qusdiscomfort");
		String qustext = request.getParameter("qustext");
		dao = SanmosqlSession.getMapper(SanmoMapper.class);
		dao.selfsave(posnum,qusday,quscondition,quspain,qusdiscomfort,qustext);
		return "redirect:index";
	}
	
	@RequestMapping(value = "/selfout")
	public String selfout(HttpServletRequest request,Model mo) {
		int num = Integer.parseInt(request.getParameter("num"));
		dao = SanmosqlSession.getMapper(SanmoMapper.class);
		ArrayList<UserDTO> list = dao.userlist(num);
		ArrayList<QuestionnaireDTO> qlist = dao.quslist(num);
		ArrayList<DocnameDTO> dlist = dao.doctorname(num);
		ArrayList<NurnameDTO> nlist = dao.nursename(num);
		mo.addAttribute("list", list);
		mo.addAttribute("qlist", qlist);
		mo.addAttribute("dlist", dlist);
		mo.addAttribute("nlist", nlist);
		return "selfout";
	}
	
	@RequestMapping(value = "/detail")
	public String detail(HttpServletRequest request,Model mo) {
		int posnum = Integer.parseInt(request.getParameter("posnum"));
		String qusday = request.getParameter("qusday");
		dao = SanmosqlSession.getMapper(SanmoMapper.class);
		ArrayList<QuestionnaireDTO> qlist = dao.alllist(posnum,qusday);
		mo.addAttribute("qlist", qlist);
		return "detail";
	}
	
	@RequestMapping(value = "/employ")
	public String employ(HttpServletRequest request,Model mo) {
	int num = Integer.parseInt(request.getParameter("num"));
	dao = SanmosqlSession.getMapper(SanmoMapper.class);
	ArrayList<UserDTO> list = dao.username(num);
	ArrayList<SanhuDTO> slist = dao.sanhuname(num);
	mo.addAttribute("list", list);
	mo.addAttribute("slist", slist);
	return "employ";
	}
	
	@RequestMapping(value = "/personalhistory")
	public String history(HttpServletRequest request,Model mo) {
		dao = SanmosqlSession.getMapper(SanmoMapper.class);
		ArrayList<SanhuDTO> slist = dao.test();
		mo.addAttribute("slist", slist);
		return "personalhistory";
	}
	
	@RequestMapping(value = "/review")
	public String review(HttpServletRequest request,Model mo) {
		int num = Integer.parseInt(request.getParameter("num"));
		dao = SanmosqlSession.getMapper(SanmoMapper.class);
		ArrayList<UserDTO> list = dao.username(num);
		mo.addAttribute("list", list);
		return "review";
	}

}
