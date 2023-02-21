package com.m2i.WebStoreApiV3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m2i.WebStoreApiV3.entity.PaypalPayment;
import com.m2i.WebStoreApiV3.repository.PaypalPaymentRepository;

@Service
public class PaypalPaymentService {
	
	@Autowired
	PaypalPaymentRepository repo;
	
	public PaypalPayment getPaypalPaymentById(int id) {
		return repo.findById(id).orElse(null);
	}

	public List<PaypalPayment> getAllPaypalPayment() {
		return repo.findAll();
	}

	public void createPaypalPayment(PaypalPayment p) {
		repo.save(p);
	}
	
	public void updatePaypalPayment(int id, PaypalPayment p) {
		PaypalPayment ListPaypalPayment = repo.findById(id).orElse(null);
		if (p!= null) {
			ListPaypalPayment.setAmount(p.getAmount());
			ListPaypalPayment.setPaymentDate(p.getPaymentDate());
			ListPaypalPayment.setAccountNumber(p.getAccountNumber());

			repo.save(ListPaypalPayment);
		}
	}
	
	public void deletePaypalPayment(int id) {
		PaypalPayment paypalPayment = repo.findById(id).orElse(null);
		if (paypalPayment!= null) {
			repo.delete(paypalPayment);
		}
		
	}

}
