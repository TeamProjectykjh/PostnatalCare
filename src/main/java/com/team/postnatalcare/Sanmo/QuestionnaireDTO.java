package com.team.postnatalcare.Sanmo;

public class QuestionnaireDTO {
 	int qusnum;
 	int posnum;
	String qusday;
	String quscondition;
	String quspain;
	String qusdiscomfort;
	String qustext;
	int num;
	public QuestionnaireDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public QuestionnaireDTO(int qusnum, int posnum, String qusday, String quscondition, String quspain,
			String qusdiscomfort, String qustext, int num) {
		super();
		this.qusnum = qusnum;
		this.posnum = posnum;
		this.qusday = qusday;
		this.quscondition = quscondition;
		this.quspain = quspain;
		this.qusdiscomfort = qusdiscomfort;
		this.qustext = qustext;
		this.num = num;
	}
	public int getQusnum() {
		return qusnum;
	}
	public void setQusnum(int qusnum) {
		this.qusnum = qusnum;
	}
	public int getPosnum() {
		return posnum;
	}
	public void setPosnum(int posnum) {
		this.posnum = posnum;
	}
	public String getQusday() {
		return qusday;
	}
	public void setQusday(String qusday) {
		this.qusday = qusday;
	}
	public String getQuscondition() {
		return quscondition;
	}
	public void setQuscondition(String quscondition) {
		this.quscondition = quscondition;
	}
	public String getQuspain() {
		return quspain;
	}
	public void setQuspain(String quspain) {
		this.quspain = quspain;
	}
	public String getQusdiscomfort() {
		return qusdiscomfort;
	}
	public void setQusdiscomfort(String qusdiscomfort) {
		this.qusdiscomfort = qusdiscomfort;
	}
	public String getQustext() {
		return qustext;
	}
	public void setQustext(String qustext) {
		this.qustext = qustext;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	
	
}
