package com.payments.app.payments.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name= "payments")
public class Payment implements Serializable {
	
	
	private static final long serialVersionUID = 1240388941393308357L;
	
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Min(100000)
	@Max(999999)
	@Column(name="payment_number")
	private Integer paymentNumber;

	
	@Column(name="payment_amount")
	private Double  paymentAmount;

	@Column(name="pending_amount")
	private Double pendingAmountA;

	@Column(name="payment_date")
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date paymentDate;
	

	
	

	public Integer getPaymentNumber() {
		return paymentNumber;
	}

	public void setPaymentNumber(Integer paymentNumber) {
		this.paymentNumber = paymentNumber;
	}

	public Double getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(Double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public Double getPendingAmountA() {
		return pendingAmountA;
	}

	public void setPendingAmountA(Double pendingAmountA) {
		this.pendingAmountA = pendingAmountA;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	
	
}
