package com.team.postnatalcare.Sanmo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.team.postnatalcareMain.UserDTO;
import com.team.postnatalcare.Sanmo.PostnatalDTO;
import com.team.postnatalcare.Sanmo.SanmoMapper;

/**
 * Handles requests for the application home page.
 */
@Controller
public class SanmoController {
	
	private static final Logger logger = LoggerFactory.getLogger(SanmoController.class);
	
	
	@Autowired
	SqlSession sqlSession;
	SanmoMapper dao;

	@RequestMapping(value = "/reservation")  // 산모예약 페이지로 가기
	public String reservation(HttpServletRequest request) {			
		return "reservation";
	}
	
	@RequestMapping(value = "/reservationlist")  // 산모예약 페이지로 가기
	public String reservationlist(HttpServletRequest request) {			
		return "reservationlist";
	}
	
	@RequestMapping(value = "/Self-Checker")
	public String SelfChecker(HttpServletRequest request) {			
		return "Self-Checker";
	}
// 산모파트 끝 
	
}
