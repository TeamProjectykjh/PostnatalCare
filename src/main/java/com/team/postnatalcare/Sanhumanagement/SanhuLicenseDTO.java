package com.team.postnatalcare.Sanhumanagement;

public class SanhuLicenseDTO {
	int linum, sanhunum;
	String liname, lipath, licode;
	public SanhuLicenseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public SanhuLicenseDTO(int linum, int sanhunum, String liname, String lipath, String licode) {
		super();
		this.linum = linum;
		this.sanhunum = sanhunum;
		this.liname = liname;
		this.lipath = lipath;
		this.licode = licode;
	}
	
	public int getLinum() {
		return linum;
	}
	public void setLinum(int linum) {
		this.linum = linum;
	}
	public int getSanhunum() {
		return sanhunum;
	}
	public void setSanhunum(int sanhunum) {
		this.sanhunum = sanhunum;
	}
	public String getLiname() {
		return liname;
	}
	public void setLiname(String liname) {
		this.liname = liname;
	}
	public String getLipath() {
		return lipath;
	}
	public void setLipath(String lipath) {
		this.lipath = lipath;
	}
	public String getlicode() {
		return licode;
	}
	public void setlicode(String licode) {
		this.licode = licode;
	}
	
}
