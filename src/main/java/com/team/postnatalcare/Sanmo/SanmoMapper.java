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
	
	public ArrayList<UserDTO> self(int num);
	public ArrayList<PostnatalDTO> sanmonum(int num);
	
	public void que(int postnum,String qusday,String quscondition,String quspain,String qusdiscomfort,String qustext);
	public ArrayList<UserDTO> userlist(int num);
	public ArrayList<QuestionnaireDTO> quslist();
	
	
	public ArrayList<QuestionnaireDTO> alllist(int qusnum);
	
	
	//public void  sanmoinsert(String name,String docname,String nurname,String startday,String endday,String baby,String protect,int emergencyphone);
}
