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

import com.m2i.WebStoreApiV3.entity.CreditCardPayment;
import com.m2i.WebStoreApiV3.service.CreditCardPaymentService;

@RestController
@RequestMapping("/creditcardpayment")
public class CreditCardPaymentController {
	
	@Autowired
	CreditCardPaymentService vService;
	
	@GetMapping("/fakeccp")
	public CreditCardPayment fakeCreditCardPayment() {
		CreditCardPayment ccp = new CreditCardPayment();
		vService.createCreditCardPayment(ccp);
		return ccp;
	}
	
	@GetMapping("/{id}")
	public CreditCardPayment getCreditCardPaymentById(@PathVariable("id") int id) {
		return vService.getCreditCardPaymentById(id);
	}
	
	@GetMapping
	public List<CreditCardPayment> getAllCreditCardPayment(){
		return vService.getAllCreditCardPayment();
	}
	
	@PostMapping
	public void postPayment(@RequestBody CreditCardPayment c) {
		vService.createCreditCardPayment(c);
	}
	
	@PutMapping("/{id}")
	public void putCreditCardPayment(@PathVariable("id") int id,@RequestBody CreditCardPayment c) {
		vService.updateCreditCardPayment(id, c);
	}
	
	@DeleteMapping("/{id}")
	public void deleteCreditCardPayment(@PathVariable("id") int id) {
		vService.deleteCreditCardPayment(id);
	}

}
