package com.restexample.crud.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="UserDetails")
public class Users implements Serializable{
	
private static final long serialVersionUID = 1L;

@Id
@Column(name="userid")
private String id;

@NotNull(message = "first name cannot be null")
@NotBlank(message="first name cannot be blank")
@Column(name="firstName")
private String fName;

@NotNull(message = "last name cannot be null")
@NotBlank(message="last name cannot be blank")
@Column(name="lastName")
private String lName;

@NotNull(message = "Email id cannot be null")
@Email(message="Invalid Email format")
@Column(name="email")
private String email;

@NotNull(message = "Pincode cannot be null")
@Column(name="pincode")
private Integer pinCode;

@NotNull(message = "Birthdate cannot be null")
@JsonFormat(pattern="dd-MMM-yyyy")
@Temporal(TemporalType.DATE)
@Column(name="birthDate")
private Date birthDate;

@Column(name="isActive")
private boolean isActive;


public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getfName() {
	return fName;
}

public void setfName(String fName) {
	this.fName = fName;
}
public String getlName() {
	return lName;
}
public void setlName(String lName) {
	this.lName = lName;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public Integer getPinCode() {
	return pinCode;
}
public void setPinCode(Integer pinCode) {
	this.pinCode = pinCode;
}
public Date getBirthDate() {
	return birthDate;
}
public void setBirthDate(Date birthDate) {
	this.birthDate = birthDate;
}
public boolean isActive() {
	return isActive;
}
public void setActive(boolean isActive) {
	this.isActive = isActive;
}
@Override
public String toString() {
	return "User [User Id=" + id + ", First Name=" + fName + ", Last Name=" + lName
			+ ", Email=" + email + ", PinCode=" + pinCode + ", isActive=" + isActive + "]";
}
}
