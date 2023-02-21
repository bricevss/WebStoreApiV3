package com.m2i.WebStoreApiV3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m2i.WebStoreApiV3.entity.CreditCardPayment;
import com.m2i.WebStoreApiV3.repository.CreditCardPaymentRepository;

@Service
public class CreditCardPaymentService {
	
	@Autowired
	CreditCardPaymentRepository repo;
	
	public CreditCardPayment getCreditCardPaymentById(int id) {
		return repo.findById(id).orElse(null);
	}

	public List<CreditCardPayment> getAllCreditCardPayment() {
		return repo.findAll();
	}

	public void createCreditCardPayment(CreditCardPayment c) {
		repo.save(c);
	}
	
	public void updateCreditCardPayment(int id, CreditCardPayment c) {
		CreditCardPayment ListCreditCardPayment = repo.findById(id).orElse(null);
		if (c!= null) {
			ListCreditCardPayment.setAmount(c.getAmount());
			ListCreditCardPayment.setPaymentDate(c.getPaymentDate());
			ListCreditCardPayment.setCardNumber(c.getCardNumber());
			ListCreditCardPayment.setExpirationDate(c.getExpirationDate());

			repo.save(ListCreditCardPayment);
		}
	}
	
	public void deleteCreditCardPayment(int id) {
		CreditCardPayment creditCardPayment = repo.findById(id).orElse(null);
		if (creditCardPayment!= null) {
			repo.delete(creditCardPayment);
		}
		
	}

}
