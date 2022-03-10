package com.sole.restfulwebservice.user;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

import ch.qos.logback.core.joran.util.beans.BeanUtil;

@RestController
@RequestMapping("/admin")
public class AdminUserController {
	private UserDaoService service;
	
	public AdminUserController(UserDaoService service) {
		this.service=service;
	}
	
	//전체 사용자 목록 조회
	@GetMapping("/users")
	public MappingJacksonValue retrieveAllUsers(){
		List<User> users = service.findAll();
		//return service.findAll(); //초기 셋팅한 세명의 사용자들 관련 메소드
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
				.filterOutAllExcept("id", "name", "joinDate", "ssn");
		
		FilterProvider filters = new SimpleFilterProvider().addFilter("UserInfo", filter);
		
		MappingJacksonValue mapping = new MappingJacksonValue(users);
		mapping.setFilters(filters);
		
		return mapping;
		}
	
	//@GetMapping("/users/{id}")
	public MappingJacksonValue retrieveUserV2(@PathVariable int id) {
		User user = service.findOne(id);
		
		if(user == null) {
			throw new UserNotFoundException(String.format("ID[%s] not found", id));
		}
		
		UserV2 userV2 = new UserV2();
		BeanUtils.copyProperties(user, userV2);
		userV2.setGrade("VIP");
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
				.filterOutAllExcept("id", "name", "joinDate", "grade");
		
		FilterProvider filters = new SimpleFilterProvider().addFilter("UserInfoV2", filter);
		
		MappingJacksonValue mapping = new MappingJacksonValue(userV2);
		mapping.setFilters(filters);
		
		return mapping;
	}
	
	/*
	 * @PostMapping("/users") public ResponseEntity<User> createUser(@RequestBody
	 * User user){ User saveUser = service.save(user);
	 * 
	 * URI location = ServletUriComponentsBuilder.fromCurrentRequest()
	 * .path("/{id}") .buildAndExpand(saveUser.getId()) .toUri();
	 * 
	 * return ResponseEntity.created(location).build();
	 * 
	 * }
	 */
}
