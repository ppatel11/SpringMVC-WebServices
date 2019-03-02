package com.synex.model;

import java.util.Date;

public class User {
	private  int userID;
	private String emaiID;
	private String firstName;
	private String lastName;
	private String status;
	private String createdByUser;
	private Date lastupdate;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int userID, String emaiID, String firstName, String lastName, String status, String createdByUser,
			Date lastupdate) {
		super();
		this.userID = userID;
		this.emaiID = emaiID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.status = status;
		this.createdByUser = createdByUser;
		this.lastupdate = lastupdate;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getEmaiID() {
		return emaiID;
	}
	public void setEmaiID(String emaiID) {
		this.emaiID = emaiID;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCreatedByUser() {
		return createdByUser;
	}
	public void setCreatedByUser(String createdByUser) {
		this.createdByUser = createdByUser;
	}
	public Date getLastupdate() {
		return lastupdate;
	}
	public void setLastupdate(Date lastupdate) {
		this.lastupdate = lastupdate;
	}
	
	
	
	
}
