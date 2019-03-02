package com.rest.sample.modal;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {

	private int userID;
	private String loginName;
	private String firstName;
	private String lastName;
	private String statusId;
	private Date lastLoginDate;
	private Date createdDate;
	private int createdBy;
	private Date modifiedDate;
	private int modifiedBy;
	private String email;
	private String jobtitle;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int userID, String loginName, String firstName, String lastName, String statusId, Date lastLoginDate,
			Date createdDate, int createdBy, Date modifiedDate, int modifiedBy, String email, String jobtitle) {
		super();
		this.userID = userID;
		this.loginName = loginName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.statusId = statusId;
		this.lastLoginDate = lastLoginDate;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.modifiedDate = modifiedDate;
		this.modifiedBy = modifiedBy;
		this.email = email;
		this.jobtitle = jobtitle;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
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
	public String getStatusId() {
		return statusId;
	}
	public void setStatusId(String statusId) {
		this.statusId = statusId;
	}
	public Date getLastLoginDate() {
		return lastLoginDate;
	}
	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public int getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public int getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(int modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getJobtitle() {
		return jobtitle;
	}
	public void setJobtitle(String jobtitle) {
		this.jobtitle = jobtitle;
	}
	
	
	
	
	
}
