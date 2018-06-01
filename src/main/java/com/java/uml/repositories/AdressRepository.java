package com.java.uml.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.uml.domain.Adress;

@Repository
public interface AdressRepository extends JpaRepository <Adress,Integer>{

	
}
