package com.team.postnatalcare.Sanmo;

public class NurDTO {
	int nurnum;
	String numname;
	public NurDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NurDTO(int nurnum, String numname) {
		super();
		this.nurnum = nurnum;
		this.numname = numname;
	}
	public int getNurnum() {
		return nurnum;
	}
	public void setNurnum(int nurnum) {
		this.nurnum = nurnum;
	}
	public String getNumname() {
		return numname;
	}
	public void setNumname(String numname) {
		this.numname = numname;
	}
	
}
