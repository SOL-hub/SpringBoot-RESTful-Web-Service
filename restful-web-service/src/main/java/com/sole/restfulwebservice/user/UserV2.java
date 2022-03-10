package com.sole.restfulwebservice.user;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFilter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonFilter("UserInfoV2")
public class UserV2 extends User{
	public UserV2(int i, String string, Date date, String string2, String string3) {
		super(i, string, date, string2, string3);
		// TODO Auto-generated constructor stub
	}

	private String grade;

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
}
