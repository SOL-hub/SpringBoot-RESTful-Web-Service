package com.sole.restfulwebservice.user;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserController {

	private UserDaoService service;
	
	//생성자
	public UserController(UserDaoService service) {
		this.service = service; //의존성 주입완료
	}
	
	@GetMapping("/users")
	public List<User> retrieveAllUsers(){
		return service.findAll();
	}
	
	@GetMapping("/users/{id}") //상세조회할 때 
	public User retrieveUser(@PathVariable int id) throws Throwable {
		//return service.findOne(id);
		User user = service.findOne(id);
		 
		if(user == null) { 
			throw new UserNotFoundException(String.format("ID[%s] not found", id)); 
			} 
		return user;
	}
	
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser = service.save(user);
		
		//사용자에게 유저값을 변환해주기 위해서 ServletUriComponentsBuilder
		//현재request되어진 request 값을 사용하기위해fromCurrentRequest
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
		.path("/{id}")
		.buildAndExpand(savedUser.getId())
		.toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		User user = service.deleteById(id);
		
		if(user == null) {
			throw new UserNotFoundException(String.format("ID[%s] not found", id));
		}
	}
	
}
