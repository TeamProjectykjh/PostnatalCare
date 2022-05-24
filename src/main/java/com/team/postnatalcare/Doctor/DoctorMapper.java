package com.team.postnatalcare.Doctor;

import java.util.ArrayList;

public interface DoctorMapper {

	public void doctorsave(int num,String doclicensename,String docpath,int docserial,String docrecord,String doctorcontent);

	public ArrayList<DoctorDTO> doctordetail(int num);
}
