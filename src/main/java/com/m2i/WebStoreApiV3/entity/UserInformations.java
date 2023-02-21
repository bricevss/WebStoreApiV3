package com.m2i.WebStoreApiV3.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.github.javafaker.Faker;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity @Table
@Getter @Setter @AllArgsConstructor @ToString @NoArgsConstructor
public class UserInformations {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String address;
	
	private String city;
	
	private String email;
	
	private String phoneNumber;
	
	@OneToOne @JoinColumn(name="id_user")	
	private User user;

	
	
	
	public UserInformations(User u) {
		Faker f = new Faker();
		
		this.address = f.address().fullAddress();
		
		this.city = f.address().city();
		
		this.email = f.internet().safeEmailAddress();
		
		this.phoneNumber = f.phoneNumber().phoneNumber();
		
		this.user = u;
			
	}
}