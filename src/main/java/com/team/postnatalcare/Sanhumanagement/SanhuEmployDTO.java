package com.team.postnatalcare.Sanhumanagement;

public class SanhuEmployDTO {
	
	int employnum, posnum, sanhunum;
	String empstartday, empendday;
	
	public SanhuEmployDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SanhuEmployDTO(int employnum, int posnum, int sanhunum, String empstartday, String empendday) {
		super();
		this.employnum = employnum;
		this.posnum = posnum;
		this.sanhunum = sanhunum;
		this.empstartday = empstartday;
		this.empendday = empendday;
	}

	public int getemploynum() {
		return employnum;
	}

	public void setemploynum(int employnum) {
		this.employnum = employnum;
	}

	public int getPosnum() {
		return posnum;
	}

	public void setPosnum(int posnum) {
		this.posnum = posnum;
	}

	public int getSanhunum() {
		return sanhunum;
	}

	public void setSanhunum(int sanhunum) {
		this.sanhunum = sanhunum;
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
