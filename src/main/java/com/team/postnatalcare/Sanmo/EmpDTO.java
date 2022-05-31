package com.team.postnatalcare.Sanmo;

public class EmpDTO {
	int employnum;
	int posnum;
	int sanhunum;
	String empstartday,empendday;
	String name;
	public EmpDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmpDTO(int employnum, int posnum, int sanhunum, String empstartday, String empendday, String name) {
		super();
		this.employnum = employnum;
		this.posnum = posnum;
		this.sanhunum = sanhunum;
		this.empstartday = empstartday;
		this.empendday = empendday;
		this.name = name;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
