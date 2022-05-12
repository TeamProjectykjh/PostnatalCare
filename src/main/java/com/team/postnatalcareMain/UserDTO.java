package com.team.postnatalcareMain;

public class UserDTO {
	
	int num;
	String id,password,job,name,gender,address,age;
	int state,phone;
	
	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserDTO(int num, String id, String password, String job, String name, String gender, String address,
			String age, int state, int phone) {
		super();
		this.num = num;
		this.id = id;
		this.password = password;
		this.job = job;
		this.name = name;
		this.gender = gender;
		this.address = address;
		this.age = age;
		this.state = state;
		this.phone = phone;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	
	
	
	
	
}
