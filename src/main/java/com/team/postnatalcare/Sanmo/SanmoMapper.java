package com.team.postnatalcare.Sanmo;

import java.util.ArrayList;


import com.team.postnatalcareMain.UserDTO;

public interface SanmoMapper {
	
	public ArrayList<UserDTO> username(int num);
	public ArrayList<DocDTO> docname();
	public ArrayList<NurDTO> nurname();
	public void insertsave(int num,int docnum,int nurnum,String startday,String endday,String baby,String protect,int emergencyphone);
	
	//개인정보 출력 부분
	public ArrayList<DocnameDTO> doctorname(int num);
	public ArrayList<NurnameDTO> nursename(int num);
	public ArrayList<PostnatalDTO> poslist(int num);
	////
	//문진표 작성 할떄 이름 값 받기//
	public ArrayList<UserDTO> self(int num);
	public ArrayList<PostnatalDTO> sanmonum(int num);
	////
	//문진표 값 저장
	public void selfsave(int postnum,String qusday,String quscondition,String quspain,String qusdiscomfort,String qustext);
	public ArrayList<UserDTO> userlist(int num);
	public ArrayList<QuestionnaireDTO> quslist(int num);
	public ArrayList<QuestionnaireDTO> alllist(int posnum,String qusday);
	////
	
	//산후조리사 협업 후기작성 
	public ArrayList<SanhuDTO> sanhuname(int num);	
 	
	//산후조리사 고용 출력 //리뷰
	public ArrayList<EmpDTO> emplist(int num);
	public ArrayList<SanhuDTO> huname(int num);
	public ArrayList<PostnatalDTO> posnum(int num);
	
	//리뷰 저장
	public void reviewsave(int employnum,int posnum,int sanhunum,float starpoint,String ment);
}
