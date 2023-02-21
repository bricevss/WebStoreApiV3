package com.m2i.WebStoreApiV3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m2i.WebStoreApiV3.entity.UserInformations;
import com.m2i.WebStoreApiV3.repository.UserInformationsRepository;

@Service
public class UserInformationsService {

	@Autowired
	UserInformationsRepository repo1;
	
	public void create(UserInformations ui) {
		repo1.save(ui);
	}

	public UserInformations getById(int id) {
		return repo1.findById(id).orElse(null);
	}

	public List<UserInformations> getAll() {
		return repo1.findAll();
	}

	public void update(int id, UserInformations ui) {
		UserInformations userInformations = repo1.findById(id).orElse(null);
		if (ui!= null) {
			userInformations.setAddress( ui.getAddress() );
			userInformations.setCity( ui.getCity());
			userInformations.setEmail( ui.getEmail());
			userInformations.setPhoneNumber( ui.getPhoneNumber() );
			userInformations.setUser( ui.getUser() );
			repo1.save(userInformations);
		}
	}

	public void delete(int id) {
		UserInformations userInformations = repo1.findById(id).orElse(null);
		if (userInformations!= null) {
			repo1.delete(userInformations);
		}
		
	}

}