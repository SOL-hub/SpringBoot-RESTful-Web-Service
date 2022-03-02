package com.sole.restfulwebservice.user;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
//@JsonIgnoreProperties(value = {"password"}) //password막아달라는 것
@JsonFilter("UserInfo")
public class User {
	private Integer id;
	
	@Size(min=2, message = "Name은 2글자이상")
	private String name;
	
	@Past
	private Date joinDate;
	
	//@JsonIgnore
	private String password;
	
	//@JsonIgnore
	private String ssn;
	
	public User(Integer id, String name, Date joinDate) {
		super();
		this.id = id;
		this.name = name;
		this.joinDate = joinDate;
	}
	public User(int i, String string, Date date, String string2, String string3) {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	public void setId() {
		// TODO Auto-generated method stub
		
	}

}
