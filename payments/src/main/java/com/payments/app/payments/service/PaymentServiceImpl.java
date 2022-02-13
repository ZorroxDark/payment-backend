package com.payments.app.payments.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.payments.app.payments.dao.PaymentDao;
import com.payments.app.payments.dto.CreditRequest;
import com.payments.app.payments.entity.Payment;

@Service
public class PaymentServiceImpl implements IPaymentService {

	@Autowired
	private PaymentDao  paymentDao;
	
	@Override
	@Transactional
	public List<Payment> findAll() {
		return (List<Payment>) paymentDao.findAll();
	}

	

	@Override
	@Transactional
	public List<Payment> generateCalInterest(CreditRequest request) {
		
		List<Payment>  resultado = new ArrayList<Payment>();
		paymentDao.deleteAll();
		
		try {
			
			Double total = request.getAmount()/request.getTerms();
		
			
			int contador = 1;
			int decremento = request.getTerms()-1;
			for(int i=0;i<request.getTerms(); i++) {
				System.out.println("Entra : "+contador);
				
				Double paymentAmount =(((request.getAmount()*request.getRate())/100)+total)*contador;
				
				
				Payment p = new Payment();
				p.setPaymentNumber(contador);
				p.setPaymentAmount(paymentAmount);
				
				p.setPendingAmountA((((request.getAmount()*request.getRate())/100)+total)*decremento);
				
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(new Date());
				calendar.add(Calendar.DAY_OF_YEAR, 7*i);
				
				p.setPaymentDate(calendar.getTime());
				
				
				paymentDao.save(p);
				
				
				contador++;
				decremento--;
				
				resultado.add(p);
				
				
				
				
			}
			
			
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return resultado;
	}

}
