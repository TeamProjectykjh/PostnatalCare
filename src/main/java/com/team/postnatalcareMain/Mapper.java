package com.team.postnatalcareMain;

import java.util.ArrayList;

import com.team.postnatalcareMain.UserDTO;

public interface Mapper {

	public void newsign(String id,String password,int state,String job,String name,String age,int phone,String gender,String address);
	
	public ArrayList<UserDTO> login(String id,String password);
	
	public ArrayList<UserDTO> myinfo(String id);
	public void modifymyinfo(String password,int state,String job,String name,String age,int phone,String gender,String address,String id);
	public ArrayList<UserDTO> userinfo();
	public void unable(int num);
	public void enable(int num);
	
	//입력인지 수정인지 구분
	public JobDTO jobswitch(String job, int usernum);
	
}
