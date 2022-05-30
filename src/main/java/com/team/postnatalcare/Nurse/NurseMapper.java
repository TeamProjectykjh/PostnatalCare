package com.team.postnatalcare.Nurse;

import java.util.ArrayList;

import com.team.postnatalcare.Doctor.DoctorDTO;

public interface NurseMapper {

	//db저장(입력)
	public void insert(int num, String nurlicensename, String nurpath, 
			int nurserial, String nurrecord, String nurcontent, String name, int phone);
	//출력
	public ArrayList<NursejoinDTO> select();
	//삭제
	public void delete(int nurnum);
	//수정할 자료 출력

	public ArrayList<NursejoinDTO> modifyselect(int nurnum);
	//수정한 자료 출력
	public void modifysava(String nurpath, String nurlicensename, int nurserial, String nurrecord, String nurcontent,
			int nurnum);
	//자세히 보기 출력
	public ArrayList<NursejoinDTO> nursedetail(int num);
	


	

	
	

}
