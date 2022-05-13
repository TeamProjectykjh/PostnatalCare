package com.team.postnatalcare.Sanhumanagement;

public class SanhuReviewDTO {
	int reviewnum, starpoint;
	String ment, writedate;
	public SanhuReviewDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public SanhuReviewDTO(int reviewnum, int starpoint, String ment, String writedate) {
		super();
		this.reviewnum = reviewnum;
		this.starpoint = starpoint;
		this.ment = ment;
		this.writedate = writedate;
	}
	
	public int getReviewnum() {
		return reviewnum;
	}
	public void setReviewnum(int reviewnum) {
		this.reviewnum = reviewnum;
	}
	public int getStarpoint() {
		return starpoint;
	}
	public void setStarpoint(int starpoint) {
		this.starpoint = starpoint;
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
