 package com.test.PARKSOL.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.test.PARKSOL.domain.User;

@Service
public class UserService {
	
private static List<User> users = new ArrayList<>();
	
	private static int usersCount = 3;
	
	static {
		users.add(new User(1, "김씨", "LESSOR", "user", "무", new Date()));
		users.add(new User(2, "최씨", "REALTOR", "user", "유", new Date()));
		users.add(new User(3, "박씨", "LESSEE", "user", "무", new Date()));
	}
	
	//사용자 전체목록
		public List<User> findAll(){
			return users;
		}
		
		//기존 아이디가 null일 경우(없을 경우) 아이디 저장
		public User save(User user) {
			if(user.getId() == null) {
				user.setId(++usersCount);
			}
			
			users.add(user);
			return user;
		}
		
		public User findOne(int id) { 
			for(User user : users) {
				if(user.getId() == id) { //매개변수로 전달받은 아이디로 전달된 아이와 같다면 아이디반환 아니면 null반환
			
			return user;
				}
			}
			return null; //같은 아이디 값이 없을 경우 null반환
		}	

}
