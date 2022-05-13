package com.team.postnatalcare.Sanhumanagement;

public class SanhuLicenseDTO {
	int linum;
	String liname, lipath, licoode;
	public SanhuLicenseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public SanhuLicenseDTO(int linum, String liname, String lipath, String licoode) {
		super();
		this.linum = linum;
		this.liname = liname;
		this.lipath = lipath;
		this.licoode = licoode;
	}
	
	public int getLinum() {
		return linum;
	}
	public void setLinum(int linum) {
		this.linum = linum;
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
	public String getLicoode() {
		return licoode;
	}
	public void setLicoode(String licoode) {
		this.licoode = licoode;
	}
	
}
