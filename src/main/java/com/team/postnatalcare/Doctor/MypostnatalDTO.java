package com.team.postnatalcare.Doctor;

public class MypostnatalDTO {

	String name;
	int num,docnum,posnum;
	
	public MypostnatalDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MypostnatalDTO(String name, int num, int docnum, int posnum) {
		super();
		this.name = name;
		this.num = num;
		this.docnum = docnum;
		this.posnum = posnum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getDocnum() {
		return docnum;
	}
	public void setDocnum(int docnum) {
		this.docnum = docnum;
	}
	public int getPosnum() {
		return posnum;
	}
	public void setPosnum(int posnum) {
		this.posnum = posnum;
	}
	
	
}
