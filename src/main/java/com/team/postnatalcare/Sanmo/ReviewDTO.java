package com.team.postnatalcare.Sanmo;

public class ReviewDTO {
	int reviewnum;
	int employnum;
	int posnum;
	int sanhunum;
	float starpoint;
	String ment;
	String name;
	public ReviewDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReviewDTO(int reviewnum, int employnum, int posnum, int sanhunum, float starpoint, String ment) {
		super();
		this.reviewnum = reviewnum;
		this.employnum = employnum;
		this.posnum = posnum;
		this.sanhunum = sanhunum;
		this.starpoint = starpoint;
		this.ment = ment;
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
	public float getStarpoint() {
		return starpoint;
	}
	public void setStarpoint(float starpoint) {
		this.starpoint = starpoint;
	}
	public String getMent() {
		return ment;
	}
	public void setMent(String ment) {
		this.ment = ment;
	}
	
	
}
