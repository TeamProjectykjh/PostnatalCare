package com.team.postnatalcare.Sanhumanagement;

public class SanhuReviewDTO {
	int reviewnum, employnum, posnum, sanhunum;
	String ment, writedate; 
	float starpoint;
	public SanhuReviewDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public SanhuReviewDTO(int reviewnum, float starpoint, int employnum, int posnum, int sanhunum, String ment,
			String writedate) {
		super();
		this.reviewnum = reviewnum;
		this.starpoint = starpoint;
		this.employnum = employnum;
		this.posnum = posnum;
		this.sanhunum = sanhunum;
		this.ment = ment;
		this.writedate = writedate;
	}
	
	public int getReviewnum() {
		return reviewnum;
	}
	public void setReviewnum(int reviewnum) {
		this.reviewnum = reviewnum;
	}
	public float getStarpoint() {
		return starpoint;
	}
	public void setStarpoint(int starpoint) {
		this.starpoint = starpoint;
	}
	public int getEmploynum() {
		return employnum;
	}
	public void setEmploynum(int employnum) {
		this.employnum = employnum;
	}
	public int getPosnum() {
		return posnum;
	}
	public void setPosnum(int posnum) {
		this.posnum = posnum;
	}
	public int getSanhunum() {
		return sanhunum;
	}
	public void setSanhunum(int sanhunum) {
		this.sanhunum = sanhunum;
	}
	public String getMent() {
		return ment;
	}
	public void setMent(String ment) {
		this.ment = ment;
	}
	public String getWritedate() {
		return writedate;
	}
	public void setWritedate(String writedate) {
		this.writedate = writedate;
	}
	
}
