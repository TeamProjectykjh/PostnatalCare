package com.team.postnatalcare.Sanmo;

import java.util.ArrayList;


import com.team.postnatalcareMain.UserDTO;

public interface SanmoMapper {

	public void newsign(String id,String password,int state,String job,String name,String age,int phone,String gender,String address);
	
	public ArrayList<UserDTO> login(String id,String password);
	public ArrayList<UserDTO> myinfo(String id);
	public void modifymyinfo(String password,int state,String job,String name,String age,int phone,String gender,String address,String id);
	
	public ArrayList<UserDTO> insert(int num);
	
	public void user(String name);
	public void doc(String docname);
	public void nur(String nurname);
	public void insertsave(String name,String docname,String nurname, String startday,String endday,String baby,String protect,int emergencyphone);
	//public void  sanmoinsert(String name,String docname,String nurname,String startday,String endday,String baby,String protect,int emergencyphone);
}
