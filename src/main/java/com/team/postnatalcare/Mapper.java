package com.team.postnatalcare;

import java.util.ArrayList;

public interface Mapper {

	public void newsign(String id,String password,int state,String job,String name,String age,int phone,String gender,String address);
	
	public ArrayList<UserDTO> login(String id,String password);
	
	public ArrayList<UserDTO> myinfo(String id);
	public void modifymyinfo(String password,int state,String job,String name,String age,int phone,String gender,String address,String id);
}