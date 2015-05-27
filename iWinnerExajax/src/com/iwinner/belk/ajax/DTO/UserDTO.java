package com.iwinner.belk.ajax.DTO;

import java.sql.Timestamp;
import java.util.Date;

public class UserDTO {

	private String userID;
	private String userName;
	private String userAddress;
	private String userProject;
	private String userEmail;
	private Integer userPhone;
	private Float userSal;
	private Date userJoinDate;
	private Timestamp userTimestamp;
	private String userComments;

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserProject() {
		return userProject;
	}

	public void setUserProject(String userProject) {
		this.userProject = userProject;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public Integer getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(Integer userPhone) {
		this.userPhone = userPhone;
	}

	public Float getUserSal() {
		return userSal;
	}

	public void setUserSal(Float userSal) {
		this.userSal = userSal;
	}

	public Date getUserJoinDate() {
		return userJoinDate;
	}

	public void setUserJoinDate(Date userJoinDate) {
		this.userJoinDate = userJoinDate;
	}

	public Timestamp getUserTimestamp() {
		return userTimestamp;
	}

	public void setUserTimestamp(Timestamp userTimestamp) {
		this.userTimestamp = userTimestamp;
	}

	public String getUserComments() {
		return userComments;
	}

	public void setUserComments(String userComments) {
		this.userComments = userComments;
	}

	@Override
	public String toString() {
		return "UserDTO [userID=" + userID + ", userName=" + userName
				+ ", userAddress=" + userAddress + ", userProject="
				+ userProject + ", userEmail=" + userEmail + ", userPhone="
				+ userPhone + ", userSal=" + userSal + ", userJoinDate="
				+ userJoinDate + ", userTimestamp=" + userTimestamp
				+ ", userComments=" + userComments + "]";
	}

	

}
