package com.ogogc.app.bean;

public class UserInfoBean {
	private int userId;
	private String userPwd;
	private String userNick;
	private String userSex;
	private String userAvatar;
	private String userType;
	private int userAccumulate;
	private String userYears;
	public String getUserYears() {
		return userYears;
	}

	public void setUserYears(String userYears) {
		this.userYears = userYears;
	}

	public int getUserAccumulate() {
		return userAccumulate;
	}

	public void setUserAccumulate(int userAccumulate) {
		this.userAccumulate = userAccumulate;
	}

	private String userName;
	private String userTitle;


	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}


	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserNick() {
		return userNick;
	}

	public void setUserNick(String userNick) {
		this.userNick = userNick;
	}


	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public String getUserAvatar() {
		return userAvatar;
	}

	public void setUserAvatar(String userAvatar) {
		this.userAvatar = userAvatar;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getUserTitle() {
		return userTitle;
	}

	public void setUserTitle(String userTitle) {
		this.userTitle = userTitle;
	}
}
