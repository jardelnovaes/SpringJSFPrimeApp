package com.jardelnovaes.spring.samples.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jardelnovaes.spring.samples.model.User;

@Service
public class UserService implements AppService<User> {

	@Override
	public void save(User entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(User entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAll() {
		return getAllMemoryExample();
	}
	
	public List<User> getAllMemoryExample() {
		List<User> users = new ArrayList<User>();
		for(int i=1; i < 11; i++){
			final User user = new User();
			user.setId(i);
			user.setName("User " + i);
			users.add(user);
		}
		return users;
	}

	
	
}
