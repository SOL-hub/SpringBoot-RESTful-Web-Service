package com.sole.restfulwebservice.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;


@Service
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
	
	public static List<User> getUsers() {
		return users;
	}

	public static void setUsers(List<User> users) {
		UserDaoService.users = users;
	}

	public static int getUsersCount() {
		return usersCount;
	}

	public static void setUsersCount(int usersCount) {
		UserDaoService.usersCount = usersCount;
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
