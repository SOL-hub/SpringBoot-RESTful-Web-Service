package com.test.Restful_API.controller;

import lombok.AllArgsConstructor;
import lombok.Data;

// 실행 전 테스트 

//@Data
//@AllArgsConstructor
public class HomeBean {

	private String message;
	
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HomeBean(String message) {
		super();
		this.message = message;
	}


}
