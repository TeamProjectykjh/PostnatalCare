package com.team.postnatalcare;

public class PostnatalDTO {
	int num;
	String startday,endday;
	String baby,protect;
	int emergencyphone;
	public PostnatalDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PostnatalDTO(int num, String startday, String endday, String baby, String protect, int emergencyphone) {
		super();
		this.num = num;
		this.startday = startday;
		this.endday = endday;
		this.baby = baby;
		this.protect = protect;
		this.emergencyphone = emergencyphone;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getStartday() {
		return startday;
	}
	public void setStartday(String startday) {
		this.startday = startday;
	}
	public String getEndday() {
		return endday;
	}
	public void setEndday(String endday) {
		this.endday = endday;
	}
	public String getBaby() {
		return baby;
	}
	public void setBaby(String baby) {
		this.baby = baby;
	}
	public String getProtect() {
		return protect;
	}
	public void setProtect(String protect) {
		this.protect = protect;
	}
	public int getEmergencyphone() {
		return emergencyphone;
	}
	public void setEmergencyphone(int emergencyphone) {
		this.emergencyphone = emergencyphone;
	}
	
	
}
