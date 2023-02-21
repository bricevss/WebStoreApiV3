package com.m2i.WebStoreApiV3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m2i.WebStoreApiV3.entity.CommandLine;
import com.m2i.WebStoreApiV3.repository.CommandLineRepository;

@Service
public class CommandLineService {
	
	@Autowired
	CommandLineRepository repo;
	
	public void create(CommandLine c) {
		repo.save(c);
	}
	
	public CommandLine getById(int id) {
		return repo.findById(id).orElse(null);
	}
	
	public List<CommandLine> getAll(){
		return repo.findAll();
	}
	
	public void update(int id, CommandLine c) {
		CommandLine commandline = repo.findById(id).orElse(null);
		if(c != null) {
			commandline.setQuantity(c.getQuantity());
			repo.save(commandline);
		}
	}
	
	public void delete(int id) {
		CommandLine commandline = repo.findById(id).orElse(null);
		if(commandline != null) {
			repo.delete(commandline);
		}
	}

}
