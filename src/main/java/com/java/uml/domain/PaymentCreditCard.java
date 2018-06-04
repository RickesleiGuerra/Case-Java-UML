package com.java.uml.domain;

import javax.persistence.Entity;

import com.java.uml.domain.enums.StatePayment;

@Entity
public class PaymentCreditCard extends Payment{

	private static final long serialVersionUID = 1L;
	
	private Integer numberOfInstallments;
	
	public PaymentCreditCard() {
		
	}

	public PaymentCreditCard(Integer id, StatePayment stateay, Request request, Integer numberOfInstallments) {
		super(id, stateay, request);
		this.numberOfInstallments = numberOfInstallments;
	}

	public Integer getNumberOfInstallments() {
		return numberOfInstallments;
	}

	public void setNumberOfInstallments(Integer numberOfInstallments) {
		this.numberOfInstallments = numberOfInstallments;
	}
}
