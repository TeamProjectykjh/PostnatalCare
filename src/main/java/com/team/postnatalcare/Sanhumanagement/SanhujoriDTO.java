package com.team.postnatalcare.Sanhumanagement;

public class SanhujoriDTO {
	int sanhunum, jobstate;
	String sanhurecord, content, startdate, sanhupath;
	
	public SanhujoriDTO(int sanhunum, int jobstate, String sanhurecord, String content, String startdate,
			String sanhupath) {
		super();
		this.sanhunum = sanhunum;
		this.jobstate = jobstate;
		this.sanhurecord = sanhurecord;
		this.content = content;
		this.startdate = startdate;
		this.sanhupath = sanhupath;
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

	public SanhujoriDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
