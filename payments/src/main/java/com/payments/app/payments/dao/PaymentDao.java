package com.payments.app.payments.dao;

import org.springframework.data.repository.CrudRepository;

import com.payments.app.payments.entity.Payment;

public interface PaymentDao extends CrudRepository<Payment, Long>{

}
