package com.team.postnatalcare.Sanhumanagement;

public class SanhuReviewDTO {
	int reviewnum, employnum, posnum, sanhunum;
	String ment; 
	float starpoint;
	public SanhuReviewDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SanhuReviewDTO(int reviewnum, int employnum, int posnum, int sanhunum, String ment,
			float starpoint) {
		super();
		this.reviewnum = reviewnum;
		this.employnum = employnum;
		this.posnum = posnum;
		this.sanhunum = sanhunum;
		this.ment = ment;
		this.starpoint = starpoint;
	}
	public int getReviewnum() {
		return reviewnum;
	}
	public void setReviewnum(int reviewnum) {
		this.reviewnum = reviewnum;
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
	public float getStarpoint() {
		return starpoint;
	}
	public void setStarpoint(float starpoint) {
		this.starpoint = starpoint;
	}
	
}
