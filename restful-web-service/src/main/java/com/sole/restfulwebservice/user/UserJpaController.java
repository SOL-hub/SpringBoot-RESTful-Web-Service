package com.sole.restfulwebservice.user;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jpa")
public class UserJpaController {
	private UserRepository userRepository;
	
	@GetMapping("/jpa/users")
	public List<User> retrieveAllUsers(){
		userRepository.findAll();
	}
	
	/*
	 * @GetMapping("/") public UserretrieveUser(int id) { User user =
	 * userRepository.fin }
	 */

	@GetMapping("/users/{id}")
	public User retrieveUser(@PathVariable int id) {
		Optional<User> user = userRepository.findById(id);
		
		if(!user.isPresent()) {

			throw new UserNotFoundException(String.format("ID[%s} not found", id));
		}
		
		Resource<User> resource = new Resource<>(user.get());
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers());
		
		return user.get();
	}
}
