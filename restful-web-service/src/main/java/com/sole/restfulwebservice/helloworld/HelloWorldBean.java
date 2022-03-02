package com.sole.restfulwebservice.helloworld;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
//@AllArgsConstructor
//이 두 어노테이션을 사용하면 setter, getter와 생성자를 일부러 밑에 쓰지 않아도된다.
@NoArgsConstructor
public class HelloWorldBean {
	private String message; //message라는 값을 사용할 수 있는 생성자 AllArgesContstructor
	
	//lombok을 사용하면 생성하지 않아도됨 (setter, getter)
	private String getmessage() {
		return this.message;
	}
	
	private void setMessage(String msg) {
		this.message = msg;
	}
	
	
	public HelloWorldBean(String string) {
		this.message = message;
	}

	
}
