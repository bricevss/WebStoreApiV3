package com.m2i.WebStoreApiV3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.m2i.WebStoreApiV3.entity.CreditCardPayment;

public interface CreditCardPaymentRepository extends JpaRepository<CreditCardPayment, Integer> {

}
