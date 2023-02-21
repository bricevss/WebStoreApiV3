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
import com.m2i.WebStoreApiV3.service.CommandService;
//import com.m2i.WebStoreAPI.service.UserService;

@RestController
@RequestMapping("/command")
public class CommandController {

	@Autowired 
	CommandService cService;
	
	//@Autowired
	//UserService uService;
	
	
	@GetMapping("/fake")
	public Command fakeCommand() {
		//User u = new User();
		//uService.create(u);
		Command c = new Command();
		cService.create(c);
		return c;
	}
	
	
	@GetMapping("/{id}")
	public Command getCommandById(@PathVariable int id) {
		return cService.getById(id);
	}
	
	@GetMapping
	public List<Command> getAllCommands(){
		return cService.getAll();
	}
	
	@PostMapping
	public void postCommand(@RequestBody Command c) {
		cService.create(c);
	}
	
	@PutMapping("/{id}")
	public void putCommand(@PathVariable int id, @RequestBody Command c) {
		cService.update(id, c);
	}
	
	@DeleteMapping("/{id}")
	public void deleteCommand(@PathVariable int id) {
		cService.delete(id);
	}
}
