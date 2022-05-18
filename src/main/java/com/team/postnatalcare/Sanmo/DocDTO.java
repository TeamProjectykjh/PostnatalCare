package com.team.postnatalcare.Sanmo;

public class DocDTO {
	int docnum;
	String docname;
	public DocDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DocDTO(int docnum, String docname) {
		super();
		this.docnum = docnum;
		this.docname = docname;
	}
	public int getDocnum() {
		return docnum;
	}
	public void setDocnum(int docnum) {
		this.docnum = docnum;
	}
	public String getDocname() {
		return docname;
	}
	public void setDocname(String docname) {
		this.docname = docname;
	}
	
	
}
