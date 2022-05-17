package com.team.postnatalcare.Doctor;

public class DoctorDTO {
	
	int docnum,num,docserial;
	String doclicensename,docpath,docrecord;
	public DoctorDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DoctorDTO(int docnum, int num, int docserial, String doclicensename, String docpath, String docrecord) {
		super();
		this.docnum = docnum;
		this.num = num;
		this.docserial = docserial;
		this.doclicensename = doclicensename;
		this.docpath = docpath;
		this.docrecord = docrecord;
	}
	public int getDocnum() {
		return docnum;
	}
	public void setDocnum(int docnum) {
		this.docnum = docnum;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getDocserial() {
		return docserial;
	}
	public void setDocserial(int docserial) {
		this.docserial = docserial;
	}
	public String getDoclicensename() {
		return doclicensename;
	}
	public void setDoclicensename(String doclicensename) {
		this.doclicensename = doclicensename;
	}
	public String getDocpath() {
		return docpath;
	}
	public void setDocpath(String docpath) {
		this.docpath = docpath;
	}
	public String getDocrecord() {
		return docrecord;
	}
	public void setDocrecord(String docrecord) {
		this.docrecord = docrecord;
	}

	
}
