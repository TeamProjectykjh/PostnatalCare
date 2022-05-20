package com.team.postnatalcare.Sanhumanagement;

public class SanhuNameDTO {
	
	int num;
	String name, sanhupath;
	
	public SanhuNameDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SanhuNameDTO(int num, String name, String sanhupath) {
		super();
		this.num = num;
		this.name = name;
		this.sanhupath = sanhupath;
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
	public String getSanhupath() {
		return sanhupath;
	}
	public void setSanhupath(String sanhupath) {
		this.sanhupath = sanhupath;
	}
	
}
