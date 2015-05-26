package com.devapp.domain;

public class User{
	public int id;

	public String phoneNumber;
	
	public String userName;

	public String password;

	public int gender;

	public int schoolId;
	
	//预留字段
	public int academyId;
	public int professionalId;
	
	public User(){}
	
	public User(String phoneNumber,String userName,String password) {
		this(phoneNumber,userName,password,-1);
	}
	
	public User(String phoneNumber,String userName,String password, int schoolNumber) {
		this(-1,phoneNumber,userName,password,-1,-1,schoolNumber,-1);
	}
	
	public User(int userId, String phoneNumber, String userName,String password, int gender,
			int academyNumber, int schoolNumber, int professionalNumber) {
		super();
		this.id = userId;
		this.phoneNumber = phoneNumber;
		this.userName = userName;
		this.password = password;
		this.gender = gender;
		this.academyId = academyNumber;
		this.schoolId = schoolNumber;
		this.professionalId = professionalNumber;
	}

	public int getUserId() {
		return id;
	}

	public void setUserId(int userId) {
		this.id = userId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public int getSchoolNumber() {
		return schoolId;
	}

	public void setSchoolNumber(int schoolNumber) {
		this.schoolId = schoolNumber;
	}

	public int getAcademyNumber() {
		return academyId;
	}

	public void setAcademyNumber(int academyNumber) {
		this.academyId = academyNumber;
	}

	public int getProfessionalNumber() {
		return professionalId;
	}

	public void setProfessionalNumber(int professionalNumber) {
		this.professionalId = professionalNumber;
	}
}
