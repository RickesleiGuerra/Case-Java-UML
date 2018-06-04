package com.java.uml.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.uml.domain.Payment;

@Repository
public interface PaymentRepository extends JpaRepository <Payment,Integer>{

	
}
