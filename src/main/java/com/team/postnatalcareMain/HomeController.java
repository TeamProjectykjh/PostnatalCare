package com.team.postnatalcareMain;
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


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	@Autowired
	SqlSession sqlSession;
	Mapper dao;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
//	실행시 /login 으로 실행해야 한다 
//	프로젝트 구성 시 로그인 후 프로그램을 사용할수 있게 설계함
//	만약 로그인 하지 않고 main페이지(/index)를 했을경우 빈껍데기인 메인 프론트창만 띄운다 의미없는 접근.
	@RequestMapping(value = "/login")
	public String login() {			
		return "login";
	}
	
//	로그인 후 메인이 되는 페이지
	@RequestMapping(value = "/index")
	public String home() {			
		return "main";
	}
	
//	로그인 창에서 회원가입(클릭)을 입력했을경우 가는 페이지이다 페이지 이동 외에 다른기능은 없다.
	@RequestMapping(value = "/signin")
	public String sign() {			
		return "signin";
	}
	
//	회원가입
//	pk값인 num이 없는 이유는 시퀀스로 1~999까지 자동으로 생성 @sql.xml쿼리 참고(pos_user_seq.nextval)
	@RequestMapping(value = "/newsign")
	public String newsing(HttpServletRequest request) {	
		String id=request.getParameter("id");
		String password=request.getParameter("password");
		int state =Integer.parseInt(request.getParameter("state"));
		String job=request.getParameter("job");
		String name=request.getParameter("name");
		String age=request.getParameter("age");
		int phone=Integer.parseInt(request.getParameter("phone"));
		String gender=request.getParameter("gender");
		String address=request.getParameter("address");
		Mapper dao = sqlSession.getMapper(Mapper.class);
		System.out.println("ID:"+id+" PW:"+password+" state:"+state+" JOB:"+job+" name:"+name+" age:"+age+" PHONE:"+phone+" GENDER:"+gender+" ADDRESS:"+address);
		dao.newsign(id,password,state,job,name,age,phone,gender,address);
		return "login";
	}
	
//	아이디 비밀번호 입력 후 로그인 버튼을 눌렀을 경우 타게 되는 로직이다.
	
	@RequestMapping(value = "userlogin")
	public String userlogin(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		Mapper dao = sqlSession.getMapper(Mapper.class);
		ArrayList<UserDTO> userinfo = dao.login(id,password);
		HttpSession hs = request.getSession(true); 
		
//		입력한 아이디와 비밀번호가 DB에 등록되어있는 계정(id,password)과 같다면 user테이블에 있는정보 전부 select가져와서 userinfo가 담는다.
//		userinfo에 쿼리로 가져온값이 있다면 id password를 정상적으로입력으로 간주한다
//		userinfo에 값이 없다면 id나 password중 한개 혹은 둘다 틀린값을 입력했음으로 쿼리 검색결과는 없다. 즉 로그인 실패
		if(userinfo.isEmpty()) {
			PrintWriter out = response.getWriter();
			response.setContentType("text/html; charset=UTF-8");
			out.println("<script>alert('�α��� ����. �ٽ� �õ����ּ���.');</script>");
			out.flush();
			return "login";
		}
		else {
//			세션에 유저 정보를 담는다 세션에 담는이유는 세션 연결이 끝나기 전까지 매번 값을 넘기지 않아도 사용이 가능해서이다.
//			사용예시 XXX님 환영합니다.
			hs.setAttribute("userinfo", userinfo);
			return "main";
		}
	}
	
//	메인 페이지에서 내정보 수정을 눌렀을때 타게되는 로직이다 .
//	id값을 가져와 DB와 커넥션 후 가져온값을 내상세정보 페이지 userinfo에 input value로 띄워준다
//	특이사항 성별은 바뀔수없기때문에 변경이 불가능하게 작성
//	modelandview 사용이유 없음. model로 사용하고 리턴으로 넘겨줘도 상관없다.
	@RequestMapping(value = "/myinfo",method = RequestMethod.GET)
	public ModelAndView myinfo(HttpServletRequest request) {
		String id = request.getParameter("id");
		Mapper dao = sqlSession.getMapper(Mapper.class);
		ArrayList<UserDTO> myinfo = dao.myinfo(id);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("myinfo");
		mav.addObject("myinfo", myinfo);
		return mav;

	}
	
//	회원정보 수정에 대한 컨트롤러. @참고 회원가입 로직과 비슷하다 insert가 아니라 update를 사용한다정도 
//	id값을 가지고 업데이트(쿼리)를 진행한다. @파라미터 마지막값이 id인 이유 (WHERE ID = 아이디)
	@RequestMapping(value = "/modifymyinfo", method = RequestMethod.POST)
	public ModelAndView modifymyinfo(HttpServletRequest request) {	
		String id=request.getParameter("id");
		String password=request.getParameter("password");
		int state =Integer.parseInt(request.getParameter("state"));
		String job=request.getParameter("job");
		String name=request.getParameter("name");
		String age=request.getParameter("age");
		int phone=Integer.parseInt(request.getParameter("phone"));
		String gender=request.getParameter("gender");
		String address=request.getParameter("address");
		Mapper dao = sqlSession.getMapper(Mapper.class);
		
//		정상적인 값들이 넘어가나 테스트를 위한 로직을 타면 로그를 CONSOLE로 확인이 가능하다
		System.out.println("ID:"+id+" PW:"+password+" state:"+state+" JOB:"+job+" name:"+name+" age:"+age+" PHONE:"+phone+" GENDER:"+gender+" ADDRESS:"+address);
		dao.modifymyinfo(password,state,job,name,age,phone,gender,address,id);
//		MAV굳이 사용안해도상관없음 test용도 아래 값은 사용안함
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login");
		mav.addObject("id", id);
		mav.addObject("password", password);
		return mav;
		
	}

}
