package com.team.postnatalcare.Nurse;

import java.util.ArrayList;

public interface NurseMapper {

	//db저장(입력)
	public void insert(int num, String nurlicensename, String nurpath, 
			String nurserial, String nurrecord, String nurcontent, String name, int phone);
	//출력
	public ArrayList<NurseDTO> select();

	

	
	

}
