package com.team.postnatalcare.Sanmo;

public class NurDTO {
	int nurnum;
	String nurname;
	public NurDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NurDTO(int nurnum, String nurname) {
		super();
		this.nurnum = nurnum;
		this.nurname = nurname;
	}
	public int getNurnum() {
		return nurnum;
	}
	public void setNurnum(int nurnum) {
		this.nurnum = nurnum;
	}
	public String getNurname() {
		return nurname;
	}
	public void setNurname(String nurname) {
		this.nurname = nurname;
	}
	
	
	
}
