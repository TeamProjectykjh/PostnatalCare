package com.team.postnatalcare.Sanhumanagement;

public class SanhujoriDTO {
	int sanhunum, jobstate, num;
	String sanhurecord, content, startdate;

	public int getSanhunum() {
		return sanhunum;
	}
	public void setSanhunum(int sanhunum) {
		this.sanhunum = sanhunum;
	}
	public int getJobstate() {
		return jobstate;
	}
	public void setJobstate(int jobstate) {
		this.jobstate = jobstate;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getSanhurecord() {
		return sanhurecord;
	}
	public void setSanhurecord(String sanhurecord) {
		this.sanhurecord = sanhurecord;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getStartdate() {
		return startdate;
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public SanhujoriDTO(int sanhunum, int jobstate, int num, String sanhurecord, String content, String startdate) {
		super();
		this.sanhunum = sanhunum;
		this.jobstate = jobstate;
		this.num = num;
		this.sanhurecord = sanhurecord;
		this.content = content;
		this.startdate = startdate;
	}

	public SanhujoriDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
