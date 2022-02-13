package com.payments.app.payments.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.payments.app.payments.dto.CreditRequest;
import com.payments.app.payments.entity.Payment;
import com.payments.app.payments.service.IPaymentService;

@RestController
public class PaymentController {
	
	@Autowired
	private IPaymentService paymentService;
	
	@GetMapping("/listaPayment")
	public List<Payment> listaPayment(){
		return paymentService.findAll();
	}

	@PostMapping("/calculateInterest")
	public List<Payment> calculateInterest(@RequestBody CreditRequest request){
		
		return paymentService.generateCalInterest(request);
		
	}
	
	
	
}
