package com.payments.app.payments.service;

import java.util.List;

import com.payments.app.payments.dto.CreditRequest;
import com.payments.app.payments.entity.Payment;

public interface IPaymentService {
	
	List<Payment> findAll();
	

	List<Payment> generateCalInterest(CreditRequest request);
	
	
	

}
