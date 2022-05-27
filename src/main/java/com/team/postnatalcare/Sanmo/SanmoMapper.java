package com.team.postnatalcare.Sanmo;

import java.util.ArrayList;


import com.team.postnatalcareMain.UserDTO;

public interface SanmoMapper {
	
	public ArrayList<UserDTO> username(int num);
	public ArrayList<DocDTO> docname();
	public ArrayList<NurDTO> nurname();
	public void user(String name);
	public void doc(String docname);
	public void nur(String nurname);
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
	public ArrayList<QuestionnaireDTO> alllist(int qusnum);
	////
	
	//산루조리사 협업 후기작성 
	public ArrayList<SanhuDTO> sanhuname(int num);
	
	//public void  sanmoinsert(String name,String docname,String nurname,String startday,String endday,String baby,String protect,int emergencyphone);
}
