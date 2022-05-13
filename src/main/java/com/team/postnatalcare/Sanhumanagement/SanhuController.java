package com.team.postnatalcare.Sanhumanagement;

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
public class SanhuController {
	
	@Autowired
	SqlSession sqlSession;
	SanmoMapper dao;

	//산후관리사 관리 페이지 이동
	@RequestMapping(value = "/sanhugg")
	public String sanhugg() {			
		return "sanhugg";
	}
	
}
