package com.team.postnatalcare;
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
//	����� /login ���� �����ؾ� �Ѵ� 
//	������Ʈ ���� �� �α��� �� ���α׷��� ����Ҽ� �ְ� ������
//	���� �α��� ���� �ʰ� main������(/index)�� ������� �󲮵����� ���� ����Ʈâ�� ���� �ǹ̾��� ����.
	@RequestMapping(value = "/login")
	public String login() {			
		return "login";
	}
	
//	�α��� �� ������ �Ǵ� ������
	@RequestMapping(value = "/index")
	public String home() {			
		return "main";
	}
	
//	�α��� â���� ȸ������(Ŭ��)�� �Է�������� ���� �������̴� ������ �̵� �ܿ� �ٸ������ ����.
	@RequestMapping(value = "/signin")
	public String sign() {			
		return "signin";
	}
	
//	ȸ������
//	pk���� num�� ���� ������ �������� 1~999���� �ڵ����� ���� @sql.xml���� ����(pos_user_seq.nextval)
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
	
//	���̵� ��й�ȣ �Է� �� �α��� ��ư�� ������ ��� Ÿ�� �Ǵ� �����̴�.
	
	@RequestMapping(value = "userlogin")
	public String userlogin(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		Mapper dao = sqlSession.getMapper(Mapper.class);
		ArrayList<UserDTO> userinfo = dao.login(id,password);
		HttpSession hs = request.getSession(true); 
		
//		�Է��� ���̵�� ��й�ȣ�� DB�� ��ϵǾ��ִ� ����(id,password)�� ���ٸ� user���̺� �ִ����� ���� select�����ͼ� userinfo�� ��´�.
//		userinfo�� ������ �����°��� �ִٸ� id password�� �����������Է����� �����Ѵ�
//		userinfo�� ���� ���ٸ� id�� password�� �Ѱ� Ȥ�� �Ѵ� Ʋ������ �Է��������� ���� �˻������ ����. �� �α��� ����
		if(userinfo.isEmpty()) {
			PrintWriter out = response.getWriter();
			response.setContentType("text/html; charset=UTF-8");
			out.println("<script>alert('�α��� ����. �ٽ� �õ����ּ���.');</script>");
			out.flush();
			return "login";
		}
		else {
//			���ǿ� ���� ������ ��´� ���ǿ� ��������� ���� ������ ������ ������ �Ź� ���� �ѱ��� �ʾƵ� ����� �����ؼ��̴�.
//			��뿹�� XXX�� ȯ���մϴ�.
			hs.setAttribute("userinfo", userinfo);
			return "main";
		}
	}
	
//	���� ���������� ������ ������ �������� Ÿ�ԵǴ� �����̴� .
//	id���� ������ DB�� Ŀ�ؼ� �� �����°��� �������� ������ userinfo�� input value�� ����ش�
//	Ư�̻��� ������ �ٲ�����⶧���� ������ �Ұ����ϰ� �ۼ�
//	modelandview ������� ����. model�� ����ϰ� �������� �Ѱ��൵ �������.
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
	
//	ȸ������ ������ ���� ��Ʈ�ѷ�. @���� ȸ������ ������ ����ϴ� insert�� �ƴ϶� update�� ����Ѵ����� 
//	id���� ������ ������Ʈ(����)�� �����Ѵ�. @�Ķ���� ���������� id�� ���� (WHERE ID = ���̵�)
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
		
//		�������� ������ �Ѿ�� �׽�Ʈ�� ���� ������ Ÿ�� �α׸� CONSOLE�� Ȯ���� �����ϴ�
		System.out.println("ID:"+id+" PW:"+password+" state:"+state+" JOB:"+job+" name:"+name+" age:"+age+" PHONE:"+phone+" GENDER:"+gender+" ADDRESS:"+address);
		dao.modifymyinfo(password,state,job,name,age,phone,gender,address,id);
//		MAV���� �����ص�������� test�뵵 �Ʒ� ���� ������
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login");
		mav.addObject("id", id);
		mav.addObject("password", password);
		return mav;
		
	}
	
//	��� ��Ʈ ����
	@RequestMapping(value = "/reservation")  // ��𿹾� �������� ����
	public String reservation(HttpServletRequest request) {			
		return "reservation";
	}
	
	@RequestMapping(value = "/reservationlist")  // ��𿹾� �������� ����
	public String reservationlist(HttpServletRequest request) {			
		return "reservationlist";
	}
	
	@RequestMapping(value = "/Self-Checker")
	public String SelfChecker(HttpServletRequest request) {			
		return "Self-Checker";
	}
// �����Ʈ �� 
	
}
