package com.sole.restfulwebservice.User;

import java.util.Date;

public class User {
	private Integer id;
	private String name;
	private Date joinDate;
	
	public User(Integer id, String name, Date joinDate) {
		super();
		this.id = id;
		this.name = name;
		this.joinDate = joinDate;
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
