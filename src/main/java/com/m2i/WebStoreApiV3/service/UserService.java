package com.m2i.WebStoreApiV3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m2i.WebStoreApiV3.entity.User;
import com.m2i.WebStoreApiV3.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository repo;
	
	public void create(User u) {
		repo.save(u);
	}

	public User getById(int id) {
		return repo.findById(id).orElse(null);
	}

	public List<User> getAll() {
		return repo.findAll();
	}

	public void update(int id, User u) {
		User user = repo.findById(id).orElse(null);
		if (u!= null) {
			user.setLogin( u.getLogin() );
			user.setPassword( u.getPassword());
			user.setConnectionNumber( u.getConnectionNumber());
			user.setUserinformations( u.getUserinformations() );
			user.setRoles( u.getRoles() );
			repo.save(user);
		}
	}

	public void delete(int id) {
		User user = repo.findById(id).orElse(null);
		if (user!= null) {
			repo.delete(user);
		}
		
	}

}