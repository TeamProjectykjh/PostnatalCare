package com.team.postnatalcare.Sanhumanagement;

public class SanhuNameDTO {
	
	int num, jobstate;
	String name, sanhupath;
	
	public SanhuNameDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SanhuNameDTO(int num, int jobstate, String name, String sanhupath) {
		super();
		this.num = num;
		this.jobstate = jobstate;
		this.name = name;
		this.sanhupath = sanhupath;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getJobstate() {
		return jobstate;
	}

	public void setJobstate(int jobstate) {
		this.jobstate = jobstate;
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
