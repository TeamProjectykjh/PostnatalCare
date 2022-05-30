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
	
   @Autowired
   SqlSession sqlSession;
   Mapper dao;

//   실행시 /login 으로 실행해야 한다 
//   프로젝트 구성 시 로그인 후 프로그램을 사용할수 있게 설계함
//   만약 로그인 하지 않고 main페이지(/index)를 했을경우 빈껍데기인 메인 프론트창만 띄운다 의미없는 접근.
   @RequestMapping(value = "/login")
   public String login() {         
      return "login";
   }
   @RequestMapping(value = "/address")
   public String address() {         
      return "address";
   }
   @RequestMapping(value = "/info")
   public String info() {         
      return "info";
   }
   
//   로그인 후 메인이 되는 페이지
   @RequestMapping(value = "/index")
   public String home(HttpServletRequest request) {
	   
      HttpSession hs = request.getSession();
      Mapper dao = sqlSession.getMapper(Mapper.class);
      String id = (String)hs.getAttribute("id");
      String password = (String)hs.getAttribute("password");
      ArrayList<UserDTO> userinfo = dao.login(id,password);
      int num = userinfo.get(0).getNum();
      String name = userinfo.get(0).getName();
      String names = userinfo.get(0).getName();
      hs.setAttribute("names", names);
      hs.setAttribute("num", num);
      hs.setAttribute("name", name);
      int switchi = 0;
      int switcc =0;
      String sqlparam = "";
      //동적으로 테이블 조회를 위한 String
      int usernum = userinfo.get(0).getNum();
      String job = userinfo.get(0).getJob();
      //조회를 위한 유저 정보 가져오기
      if(job.equals("산후조리사")) {
         sqlparam = "pos_sanhujori";
         
         //유저 테이블에 job이 산후조리사이면 산후조리사 테이블 조회를 위한 테이블이름 저장
      }else if(job.equals("의사")){
    	  sqlparam = "pos_doctor";
      }
   	else if(job.equals("간호사")){
 	  sqlparam = "pos_nurse";
   	}
     
      if(sqlparam != "") {
         //sqlparam에 값이 없다면 넘기기
         //(추후 원하는 사람있다면 else if로 값 넣기)
         JobDTO dto = dao.jobswitch(sqlparam, usernum);
         if(dto != null) {
            switchi = 1;
         }
         if(dto != null) {
             switcc = 1;
          }
      }
      if(job.equals("산모")) {
    	  hs.setAttribute("empstate", 1);
      } else {
    	  hs.setAttribute("empstate", 0);
      }
      hs.setAttribute("switcc", switcc);
      hs.setAttribute("switchi", switchi);
      return "main";
   }
   
//   로그인 창에서 회원가입(클릭)을 입력했을경우 가는 페이지이다 페이지 이동 외에 다른기능은 없다.
   @RequestMapping(value = "/signin")
   public String sign() {         
      return "signin";
   }
   
//   회원가입
//   pk값인 num이 없는 이유는 시퀀스로 1~999까지 자동으로 생성 @sql.xml쿼리 참고(pos_user_seq.nextval)
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
   
//   아이디 비밀번호 입력 후 로그인 버튼을 눌렀을 경우 타게 되는 로직이다.
   
   @RequestMapping(value = "userlogin")
   public String userlogin(HttpServletRequest request,HttpServletResponse response) throws IOException {
      HttpSession hs = request.getSession(true);
      String id = request.getParameter("id");
      String password = request.getParameter("password");
      hs.setAttribute("id", id);
      hs.setAttribute("password", password);
      Mapper dao = sqlSession.getMapper(Mapper.class);
      ArrayList<UserDTO> userinfo = dao.login(id,password);
       
      
//      입력한 아이디와 비밀번호가 DB에 등록되어있는 계정(id,password)과 같다면 user테이블에 있는정보 전부 select가져와서 userinfo가 담는다.
//      userinfo에 쿼리로 가져온값이 있다면 id password를 정상적으로입력으로 간주한다
//      userinfo에 값이 없다면 id나 password중 한개 혹은 둘다 틀린값을 입력했음으로 쿼리 검색결과는 없다. 즉 로그인 실패
      if(userinfo.isEmpty()) {
         PrintWriter out = response.getWriter();
         response.setContentType("text/html; charset=UTF-8");
         out.println("<script>alert('로그인 실패.');</script>");
         out.flush();
         return "login";
      }
      else if(userinfo.get(0).state==1){
         hs.setAttribute("userinfo", userinfo);        
         return "redirect:index";
         
//         세션에 유저 정보를 담는다 세션에 담는이유는 세션 연결이 끝나기 전까지 매번 값을 넘기지 않아도 사용이 가능해서이다.
//         사용예시 XXX님 환영합니다.
      }else {
         PrintWriter out = response.getWriter();
         response.setContentType("text/html; charset=UTF-8");
         out.println("<script>alert('로그인 실패. 관리자에게 가입승인을 요청하세요');</script>");
         out.flush();
         return "login";
      }
   }
   
//   메인 페이지에서 내정보 수정을 눌렀을때 타게되는 로직이다 .
//   id값을 가져와 DB와 커넥션 후 가져온값을 내상세정보 페이지 userinfo에 input value로 띄워준다
//   특이사항 성별은 바뀔수없기때문에 변경이 불가능하게 작성
//   modelandview 사용이유 없음. model로 사용하고 리턴으로 넘겨줘도 상관없다.
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
   
//   회원정보 수정에 대한 컨트롤러. @참고 회원가입 로직과 비슷하다 insert가 아니라 update를 사용한다정도 
//   id값을 가지고 업데이트(쿼리)를 진행한다. @파라미터 마지막값이 id인 이유 (WHERE ID = 아이디)
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
      
//      정상적인 값들이 넘어가나 테스트를 위한 로직을 타면 로그를 CONSOLE로 확인이 가능하다
      System.out.println("ID:"+id+" PW:"+password+" state:"+state+" JOB:"+job+" name:"+name+" age:"+age+" PHONE:"+phone+" GENDER:"+gender+" ADDRESS:"+address);
      dao.modifymyinfo(password,state,job,name,age,phone,gender,address,id);
//      MAV굳이 사용안해도상관없음 test용도 아래 값은 사용안함
      ModelAndView mav = new ModelAndView();
      mav.setViewName("login");
      mav.addObject("id", id);
      mav.addObject("password", password);
      return mav;
      
   }
   
   
   @RequestMapping(value = "/userinfo",method = RequestMethod.GET)
   public ModelAndView userinfo(HttpServletRequest request) {
      
      Mapper dao = sqlSession.getMapper(Mapper.class);
      ArrayList<UserDTO> userinfo = dao.userinfo();
      ModelAndView mav = new ModelAndView();
      mav.setViewName("userinfo");
      mav.addObject("usertable", userinfo);
      return mav;

   }
   
   @RequestMapping(value = "/able")
   public void state(HttpServletRequest request,HttpServletResponse response) throws IOException {
      int num = Integer.parseInt(request.getParameter("num"));
      int state = Integer.parseInt(request.getParameter("state"));
      Mapper dao = sqlSession.getMapper(Mapper.class);
      if(state==1) {
         dao.unable(num);
         PrintWriter out = response.getWriter();
         response.setContentType("text/html; charset=UTF-8");
         out.println("<script>alert('계정이 비활성화 되었습니다.');location.href='/PostnatalCare/userinfo';</script>");
         out.flush();
      }
      else {
         dao.enable(num);
         PrintWriter out = response.getWriter();
         response.setContentType("text/html; charset=UTF-8");
         out.println("<script>alert('계정이 활성화 되었습니다.');location.href='/PostnatalCare/userinfo';</script>");
         out.flush();
      }
   }
   

}