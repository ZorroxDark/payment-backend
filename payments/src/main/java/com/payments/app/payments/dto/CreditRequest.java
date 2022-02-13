package com.payments.app.payments.dto;

import java.io.Serializable;

public class CreditRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8283131492017874610L;
	
	
	private Double amount;
	private Integer terms;
	private Double rate;
	
	
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Integer getTerms() {
		return terms;
	}
	public void setTerms(Integer terms) {
		this.terms = terms;
	}
	public Double getRate() {
		return rate;
	}
	public void setRate(Double rate) {
		this.rate = rate;
	}
	
	
	
	
	
	

}
