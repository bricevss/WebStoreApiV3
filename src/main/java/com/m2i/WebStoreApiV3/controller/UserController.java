package com.m2i.WebStoreApiV3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.m2i.WebStoreApiV3.entity.Command;
import com.m2i.WebStoreApiV3.entity.Role;
import com.m2i.WebStoreApiV3.entity.UserInformations;
import com.m2i.WebStoreApiV3.entity.User;
import com.m2i.WebStoreApiV3.service.RoleService;
import com.m2i.WebStoreApiV3.service.UserInformationsService;
import com.m2i.WebStoreApiV3.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService uService;
	
	@Autowired
	UserInformationsService uiService;
	
	@Autowired
	RoleService rService;
	
	@GetMapping("/fakeUser")
	public User fakeUser() {
		User u = new User();
		UserInformations ui = new UserInformations(u);
		
		Role r = rService.getById(1);
		u.getRoles().add(r);
		r.getUsers().add(u);
		
			
		u.setUserinformations(ui);
		
		uService.create(u);
		uiService.create(ui);	
		rService.update(1,r);
		return u;
	}
	
	@GetMapping("/total/{id}")
	public User getMontantTotalByUser(@PathVariable("id") int id) {
		
		User u = uService.getById(id);
		
		List<Command> maList = u.getCommands();
		int somme = 0;
		
		for(Command c:maList) {
			
			somme = (int) (somme + c.getPayment().getAmount());
			
		}
		
		return uService.getById(somme);
	}
	
	@GetMapping("/{id}")
	public User getUserById(@PathVariable("id") int id) {
		return uService.getById(id);
	}
	
	@GetMapping
	public List<User> getAll(){
		return uService.getAll();
	}
	
	@PostMapping
	public void postUser(@RequestBody User u,@RequestBody UserInformations ui ) {
		uService.create(u);
		uiService.create(ui);
	}
	
	@PutMapping("/{id}")
	public void putUser(@PathVariable("id") int id,@RequestBody User u) {
		uService.update(id, u);
	}
	
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable("id") int id) {
		uService.delete(id);
		uiService.delete(id);
	}
	
}
