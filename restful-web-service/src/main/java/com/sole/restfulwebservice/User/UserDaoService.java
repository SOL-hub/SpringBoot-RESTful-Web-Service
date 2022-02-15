package com.sole.restfulwebservice.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDaoService {
	private static List<User> users = new ArrayList<User>();
	
	private static int usersCount = 3;
	
	static {
		String name;
		int id;
//		users.add(new User(id:1, name:"Kenneth", new Date()));
//		users.add(new User(id:2, name:"Alice", new Date()));
//		users.add(new User(id:3, name:"Elena", new Date()));
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User save(User user) {
		if(user.getId() == null) {
			user.setId(++usersCount);
		}
		
		users.add(user);
		return user;
	}
	
	public User findOne(int id) {
		for(User user:users) {
			if(user.getId() == id) {
				return user;
			}
		}
		
		return null;
		
	}
}
