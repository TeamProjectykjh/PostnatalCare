package com.team.postnatalcare.Sanmo;

public class DocDTO {
	int docnum,num;
	String doclicensename,docpath,docrecord,doctorcontent;
	int docserial;
	String name;
	public DocDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DocDTO(int docnum, int num, String doclicensename, String docpath, String docrecord, String doctorcontent,
			int docserial, String name) {
		super();
		this.docnum = docnum;
		this.num = num;
		this.doclicensename = doclicensename;
		this.docpath = docpath;
		this.docrecord = docrecord;
		this.doctorcontent = doctorcontent;
		this.docserial = docserial;
		this.name = name;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
	
}
