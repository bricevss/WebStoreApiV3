package com.m2i.WebStoreApiV3.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.github.javafaker.Faker;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table
@Getter @Setter
@AllArgsConstructor
@ToString
public class PaypalPayment extends Payment {
	
	@Column(name="accountNumber")
	private String AccountNumber;

	public PaypalPayment() {
		
		Faker f = new Faker();
		
		this.amount = f.number().numberBetween(1, 300);
		this.paymentDate = f.date().birthday();
		this.AccountNumber = Integer.toString(f.number().numberBetween(100000, 999999));
	}		
}