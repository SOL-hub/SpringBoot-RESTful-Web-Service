package com.sole.restfulwebservice.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//200은 ok
//400은 client가 뭔가문제
//500은 서버 내부에 문제

@ResponseStatus(HttpStatus.NOT_FOUND)//이제 이 예외클래스는 404로 postman에 실행해보면 status값은 404로 떠야 정상작동한 것이다.
public class UserNotFoundException extends RuntimeException {
	public UserNotFoundException(String message) {
		super(message); //생성자는 부모클래스에서 전달받은 메세지로
	}
}
