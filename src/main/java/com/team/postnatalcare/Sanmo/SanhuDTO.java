package com.team.postnatalcare.Sanmo;

public class SanhuDTO {
	int sanhunum, jobstate;
	String sanhurecord, content, startdate, sanhupath;
	int num;
	String name;
	public SanhuDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SanhuDTO(int sanhunum, int jobstate, String sanhurecord, String content, String startdate, String sanhupath,
			int num, String name) {
		super();
		this.sanhunum = sanhunum;
		this.jobstate = jobstate;
		this.sanhurecord = sanhurecord;
		this.content = content;
		this.startdate = startdate;
		this.sanhupath = sanhupath;
		this.num = num;
		this.name = name;
	}
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
	public String getSanhupath() {
		return sanhupath;
	}
	public void setSanhupath(String sanhupath) {
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
	
	
	
}
