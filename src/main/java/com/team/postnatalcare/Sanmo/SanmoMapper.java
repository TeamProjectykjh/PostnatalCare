package com.team.postnatalcare.Sanmo;

import java.util.ArrayList;


import com.team.postnatalcareMain.UserDTO;

public interface SanmoMapper {
	
	public ArrayList<UserDTO> test(String name);
	public ArrayList<DocDTO> test1();
	public ArrayList<NurDTO> test2();
	public void user(String name);
	public void doc(String docname);
	public void nur(String nurname);
	public void insertsave(String name,String docname,String nurname, String startday,String endday,String baby,String protect,int emergencyphone);
	//public void  sanmoinsert(String name,String docname,String nurname,String startday,String endday,String baby,String protect,int emergencyphone);
}
