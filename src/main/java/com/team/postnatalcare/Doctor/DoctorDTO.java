package com.team.postnatalcare.Doctor;

public class DoctorDTO {
	
	int docnum,num;
	String doclicensename,docpath,docrecord,doctorcontent;
	int docserial;
	public DoctorDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DoctorDTO(int docnum, int num, String doclicensename, String docpath, String docrecord, String doctorcontent,
			int docserial) {
		super();
		this.docnum = docnum;
		this.num = num;
		this.doclicensename = doclicensename;
		this.docpath = docpath;
		this.docrecord = docrecord;
		this.doctorcontent = doctorcontent;
		this.docserial = docserial;
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
	public String getDoctorcontent() {
		return doctorcontent;
	}
	public void setDoctorcontent(String doctorcontent) {
		this.doctorcontent = doctorcontent;
	}
	public int getDocserial() {
		return docserial;
	}
	public void setDocserial(int docserial) {
		this.docserial = docserial;
	}
	
	
}
