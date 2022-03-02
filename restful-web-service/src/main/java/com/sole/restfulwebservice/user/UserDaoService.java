package com.sole.restfulwebservice.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;


@Service //Component도 좋지만 더 명확한 어노테이션 사용
public class UserDaoService { //비지니스 로직 추가
	private static List<User> users = new ArrayList<User>(); //가상에 메모리에 데이터를 추가
	
	
	private static int usersCount = 3; //초기데이터가 3개니깐 
	
	//가상의 초기데이터를 가지고 실행
	static {
		String name;
		int id;
		users.add(new User(1, "Kenneth", new Date(), "pass1", "701010-111111"));
		users.add(new User(2, "Alice", new Date(), "pass2", "801010-222222"));
		users.add(new User(3, "Elena", new Date(), "pass3", "901010-222222"));
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

	//사용자 전체목록
	public List<User> findAll(){
		return users;
	}
	
	public User save(User user) {
		if(user.getId() == null) {
			user.setId(++usersCount); //usersCount다음에 다음 id로 저장
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
	
	public User deleteById(int id) {//아이디에 의해서 삭제하기
		Iterator<User> iterator = users.iterator();
		
		while(iterator.hasNext()) {
			User user = iterator.next();
			
			if(user.getId() == id) {
				iterator.remove();
				return user;
			}
		}
		
		return null;
	}

}
