package com.team.postnatalcare.Nurse;

import java.util.ArrayList;

public interface NurseMapper {

	//db저장(입력)
	public void insert(int num, String nurlicensename, String nurpath, 
			String nurserial, String nurrecord, String nurcontent, String name, int phone);
	//출력
	public ArrayList<NurseDTO> select();
	//삭제
	public void delete(int nurnum);
	//수정할 자료 출력
	public ArrayList<NursejoinDTO> modifyselect(int nurnum);
	//수정한 자료 출력
	public void modifysava(int nurnum, String nurpath, String nurlicensename, int nurserial, String nurrecord,
			String nurcontent);

	

	
	

}
