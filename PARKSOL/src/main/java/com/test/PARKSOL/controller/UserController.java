package com.test.PARKSOL.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.test.PARKSOL.domain.User;
import com.test.PARKSOL.service.UserService;

@RestController
public class UserController {
	
	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	//사용자 전체 목록
	@GetMapping("/users")
	public List<User> UserAllList(){
		return userService.findAll();
		}
	
	
	//사용자 단일 (상세)조회
		@GetMapping("/users/{id}")
		public User UserfindOne(@PathVariable int id) {
			User user = userService.findOne(id);
			
			//출력결과가 null일 때 빈 화면말고 예외상태로
			//if(user == null) { 
			//	throw new UserNotFoundException(String.format("ID[%s] not found", id));
			//}
			return user;
		} 
	
	//사용자 등록
	@PostMapping("/users")
	public  ResponseEntity<User> createUser(@RequestBody User user) {
		User savedUser = userService.save(user);
			
		//요청값 변환 - HTTP 상태코드 201로 변환하여 created, 등록된 것을 바로 확인할 수 있도록 설정
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedUser.getId())
				.toUri();
			
			return ResponseEntity.created(location).build();
		}
	

}
