package com.team.postnatalcare.Doctor;

public class DoctorlistDTO {

	String docpath,doclicensename;
	int num;
	String name;
	public DoctorlistDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DoctorlistDTO(String docpath, String doclicensename, int num, String name) {
		super();
		this.docpath = docpath;
		this.doclicensename = doclicensename;
		this.num = num;
		this.name = name;
	}
	public String getDocpath() {
		return docpath;
	}
	public void setDocpath(String docpath) {
		this.docpath = docpath;
	}
	public String getDoclicensename() {
		return doclicensename;
	}
	public void setDoclicensename(String doclicensename) {
		this.doclicensename = doclicensename;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
