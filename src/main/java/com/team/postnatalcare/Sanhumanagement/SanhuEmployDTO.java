package com.team.postnatalcare.Sanhumanagement;

public class SanhuEmployDTO {
	
	int employnum, posnum, sanhunum;
	String empstartday, empendday, empappointment;
	
	public SanhuEmployDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SanhuEmployDTO(int employnum, int posnum, int sanhunum, String empstartday, String empendday,
			String empappointment) {
		super();
		this.employnum = employnum;
		this.posnum = posnum;
		this.sanhunum = sanhunum;
		this.empstartday = empstartday;
		this.empendday = empendday;
		this.empappointment = empappointment;
	}

	public int getEmploynum() {
		return employnum;
	}

	public void setEmploynum(int employnum) {
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

	public String getEmpappointment() {
		return empappointment;
	}

	public void setEmpappointment(String empappointment) {
		this.empappointment = empappointment;
	}	
	
}
