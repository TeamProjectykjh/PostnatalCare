package com.team.postnatalcare.Sanhumanagement;

public class SanhuEmployDTO {
	
	int empnum;
	String empstartday, empendday;
	
	public SanhuEmployDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public SanhuEmployDTO(int empnum, String empstartday, String empendday) {
		super();
		this.empnum = empnum;
		this.empstartday = empstartday;
		this.empendday = empendday;
	}
	
	public int getEmpnum() {
		return empnum;
	}
	public void setEmpnum(int empnum) {
		this.empnum = empnum;
	}
	public String getEmpstartday() {
		return empstartday;
	}
	public void setEmpstartday(String empstartday) {
		this.empstartday = empstartday;
	}
	public String getEmpendday() {
		return empendday;
	}
	public void setEmpendday(String empendday) {
		this.empendday = empendday;
	}
	
}
