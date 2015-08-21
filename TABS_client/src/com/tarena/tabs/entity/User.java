package com.tarena.tabs.entity;

public class User {

	private int userId;
	private String userLoginName;
	private String password;
	private String userName;
	private String userTelephone;
	private String userCertifType;
	private String userCertifNum;
	private String userEmail;
	private String userCreationDate;
	private String userLastLoginTime;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(int userId, String userLoginName, String password, String userName, String userTelephone,
			String userCertifType, String userCertifNum, String userEmail, String userCreationDate,
			String userLastLoginTime) {
		super();
		this.userId = userId;
		this.userLoginName = userLoginName;
		this.password = password;
		this.userName = userName;
		this.userTelephone = userTelephone;
		this.userCertifType = userCertifType;
		this.userCertifNum = userCertifNum;
		this.userEmail = userEmail;
		this.userCreationDate = userCreationDate;
		this.userLastLoginTime = userLastLoginTime;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserLoginName() {
		return userLoginName;
	}

	public void setUserLoginName(String userLoginName) {
		this.userLoginName = userLoginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserTelephone() {
		return userTelephone;
	}

	public void setUserTelephone(String userTelephone) {
		this.userTelephone = userTelephone;
	}

	public String getUserCertifType() {
		return userCertifType;
	}

	public void setUserCertifType(String userCertifType) {
		this.userCertifType = userCertifType;
	}

	public String getUserCertifNum() {
		return userCertifNum;
	}

	public void setUserCertifNum(String userCertifNum) {
		this.userCertifNum = userCertifNum;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserCreationDate() {
		return userCreationDate;
	}

	public void setUserCreationDate(String userCreationDate) {
		this.userCreationDate = userCreationDate;
	}

	public String getUserLastLoginTime() {
		return userLastLoginTime;
	}

	public void setUserLastLoginTime(String userLastLoginTime) {
		this.userLastLoginTime = userLastLoginTime;
	}

	public String toString() {
		return this.userName + "  " + this.userTelephone + "  " + this.userEmail;
	}

}
