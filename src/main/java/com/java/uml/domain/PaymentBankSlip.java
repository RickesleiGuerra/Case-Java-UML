package com.java.uml.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.java.uml.domain.enums.StatePayment;

@Entity
public class PaymentBankSlip extends Payment {

	private static final long serialVersionUID = 1L;
	
	private Date dueDate;
	private Date payDay;
	
	public PaymentBankSlip() {
		
	}

	public PaymentBankSlip(Integer id, StatePayment stateay, Request request, Date dueDate, Date payDay) {
		super(id, stateay, request);
		this.dueDate = dueDate;
		this.payDay = payDay;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Date getPayDay() {
		return payDay;
	}

	public void setPayDay(Date payDay) {
		this.payDay = payDay;
	}	
}
