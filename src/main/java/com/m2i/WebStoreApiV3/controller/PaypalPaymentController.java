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

import com.m2i.WebStoreApiV3.entity.PaypalPayment;
import com.m2i.WebStoreApiV3.service.PaypalPaymentService;

@RestController
@RequestMapping("/paypalpayment")
public class PaypalPaymentController {
	
	@Autowired
	PaypalPaymentService vService;
	
	@GetMapping("/fakepp")
	public PaypalPayment fakePaypalPayment() {
		PaypalPayment pp = new PaypalPayment();
		vService.createPaypalPayment(pp);
		return pp;
	}
	
	@GetMapping("/{id}")
	public PaypalPayment getPaymentById(@PathVariable("id") int id) {
		return vService.getPaypalPaymentById(id);
	}
	
	@GetMapping
	public List<PaypalPayment> getAllPayment(){
		return vService.getAllPaypalPayment();
	}
	
	@PostMapping
	public void postPayment(@RequestBody PaypalPayment p) {
		vService.createPaypalPayment(p);
	}
	
	@PutMapping("/{id}")
	public void putPayment(@PathVariable("id") int id,@RequestBody PaypalPayment p) {
		vService.updatePaypalPayment(id, p);
	}
	
	@DeleteMapping("/{id}")
	public void deletePayment(@PathVariable("id") int id) {
		vService.deletePaypalPayment(id);
	}

}
