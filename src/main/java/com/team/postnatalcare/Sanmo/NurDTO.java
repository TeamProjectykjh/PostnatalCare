package com.team.postnatalcare.Sanmo;

public class NurDTO {
	int nurnum, num;
	String nurlicensename, nurpath;
	int nurserial;
	String nurrecord,nurcontent;
	String name;
	public NurDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NurDTO(int nurnum, int num, String nurlicensename, String nurpath, int nurserial, String nurrecord,
			String nurcontent, String name) {
		super();
		this.nurnum = nurnum;
		this.num = num;
		this.nurlicensename = nurlicensename;
		this.nurpath = nurpath;
		this.nurserial = nurserial;
		this.nurrecord = nurrecord;
		this.nurcontent = nurcontent;
		this.name = name;
	}
	public int getNurnum() {
		return nurnum;
	}
	public void setNurnum(int nurnum) {
		this.nurnum = nurnum;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getNurlicensename() {
		return nurlicensename;
	}
	public void setNurlicensename(String nurlicensename) {
		this.nurlicensename = nurlicensename;
	}
	public String getNurpath() {
		return nurpath;
	}
	public void setNurpath(String nurpath) {
		this.nurpath = nurpath;
	}
	public int getNurserial() {
		return nurserial;
	}
	public void setNurserial(int nurserial) {
		this.nurserial = nurserial;
	}
	public String getNurrecord() {
		return nurrecord;
	}
	public void setNurrecord(String nurrecord) {
		this.nurrecord = nurrecord;
	}
	public String getNurcontent() {
		return nurcontent;
	}
	public void setNurcontent(String nurcontent) {
		this.nurcontent = nurcontent;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
