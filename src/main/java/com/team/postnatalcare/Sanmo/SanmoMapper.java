package com.team.postnatalcare.Sanmo;

import java.util.ArrayList;

import com.team.postnatalcareMain.UserDTO;

public interface SanmoMapper {

	public void newsign(String id,String password,int state,String job,String name,String age,int phone,String gender,String address);
	
	public ArrayList<UserDTO> login(String id,String password);
	
	public ArrayList<UserDTO> myinfo(String id);
	public void modifymyinfo(String password,int state,String job,String name,String age,int phone,String gender,String address,String id);
}
